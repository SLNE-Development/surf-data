package dev.slne.surf.data.test.paper.ticket

import kotlinx.serialization.Serializable

@Serializable
data class Ticket(
    val id: Int,
    val ticketId: String
) {
    override fun toString(): String {
        return "Ticket(id=$id, ticketId=$ticketId)"
    }
}
