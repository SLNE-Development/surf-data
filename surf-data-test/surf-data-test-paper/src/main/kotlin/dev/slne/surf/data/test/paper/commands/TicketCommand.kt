package dev.slne.surf.data.test.paper.commands

import com.github.shynixn.mccoroutine.folia.launch
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandAPICommand
import dev.jorel.commandapi.kotlindsl.getValue
import dev.jorel.commandapi.kotlindsl.textArgument
import dev.slne.surf.data.core.context.getBean
import dev.slne.surf.data.core.utils.measureTimeReturning
import dev.slne.surf.data.test.paper.plugin
import dev.slne.surf.data.test.paper.ticket.TicketService
import dev.slne.surf.surfapi.core.api.messages.adventure.sendText
import java.util.*

private val ticketService get() = plugin.context.getBean<TicketService>()

fun ticketCommand() = commandAPICommand("ticket") {
    textArgument("ticketId")

    anyExecutor { sender, arguments ->
        val ticketId: String by arguments

        val ticketUuid = runCatching {
            UUID.fromString(ticketId)
        }.getOrElse {
            sender.sendText {
                error("Invalid UUID format: ")
                variableValue(ticketId)
                error(". Please provide a valid ticket Id.")
            }

            return@anyExecutor
        }

        plugin.launch {
            sender.sendText {
                info("Fetching ticket with Id: ")
                variableValue(ticketId)
                info(".")
            }


            val (ticket, duration) = measureTimeReturning {
                ticketService.getTicketByTicketId(ticketUuid)
            }

            sender.sendText {
                if (ticket != null) {
                    success("Ticket found: ")
                    variableValue(ticket.toString())
                    success(". ")
                } else {
                    error("No ticket found with Id: ")
                    variableValue(ticketId)
                    error(". ")
                }

                info("Operation took ")
                variableValue(duration.inWholeMilliseconds)
                info(" ms.")
            }
        }
    }
}