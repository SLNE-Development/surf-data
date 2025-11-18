package dev.slne.surf.data.test.paper.ticket

import org.springframework.stereotype.Component
import java.util.*

@Component
class TicketService(
    private val ticketRepository: TicketRepository
) {
    suspend fun getTicketByTicketId(ticketId: UUID) =
        ticketRepository.findTicketByTicketId(ticketId)
}