package dev.slne.surf.data.test.paper.ticket

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import java.util.*

@Service
class TicketService(
    private val ticketClient: TicketClient
) {
    suspend fun getTicketByTicketId(ticketId: UUID) = withContext(Dispatchers.IO) {
        ticketClient.findTicketByTicketId(ticketId)
    }
}