package dev.slne.surf.data.test.paper.ticket

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

@FeignClient(name = "ticketClient", url = "https://api.castcrafter.de/v1/ticket")
interface TicketClient {
    @GetMapping("/{ticketId}")
    fun findTicketByTicketId(
        @PathVariable ticketId: UUID
    ): Ticket?
}