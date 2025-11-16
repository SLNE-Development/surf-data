package dev.slne.surf.data.test.paper.ticket

import java.util.*

data class Ticket(
    val id: Int,
    val ticketId: UUID
) {
    override fun toString(): String {
        return "Ticket(id=$id, ticketId=$ticketId)"
    }
}
