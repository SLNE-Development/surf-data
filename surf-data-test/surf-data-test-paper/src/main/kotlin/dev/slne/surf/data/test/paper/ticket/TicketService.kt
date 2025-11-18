package dev.slne.surf.data.test.paper.ticket

import dev.slne.surf.data.core.utils.onStatus
import dev.slne.surf.data.core.utils.requireSuccess
import dev.slne.surf.data.core.web.WebClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import java.util.*

@Service
class TicketService {
    private val ticketClient by lazy {
        WebClient.create()
    }

    suspend fun getTicketByTicketId(ticketId: UUID) = withContext(Dispatchers.IO) {
        ticketClient.get("ticket/$ticketId")
            .onStatus(HttpStatusCode.NotFound) { return@withContext null }
            .requireSuccess()
            .body<Ticket?>()
    }
}