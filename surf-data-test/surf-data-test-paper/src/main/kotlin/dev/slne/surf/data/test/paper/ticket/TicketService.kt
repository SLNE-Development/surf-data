package dev.slne.surf.data.test.paper.ticket

import dev.slne.surf.data.core.configuration.createWebClient
import org.springframework.stereotype.Component
import java.util.*

@Component
class TicketService {
    private val ticketRepository by lazy {
        createWebClient<TicketRepository>()
    }

    suspend fun getTicketByTicketId(ticketId: UUID) =
        ticketRepository.findTicketByTicketId(ticketId)
}