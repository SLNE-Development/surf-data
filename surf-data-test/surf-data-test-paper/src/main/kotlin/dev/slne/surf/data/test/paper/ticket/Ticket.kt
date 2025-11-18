package dev.slne.surf.data.test.paper.ticket

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ticket(
    @SerialName("ticketUid")
    val ticketId: String
) {
    override fun toString(): String {
        return "Ticket(ticketId='$ticketId')"
    }
}
