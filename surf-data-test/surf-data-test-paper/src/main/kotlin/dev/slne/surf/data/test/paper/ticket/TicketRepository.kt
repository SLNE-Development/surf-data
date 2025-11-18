package dev.slne.surf.data.test.paper.ticket

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.toEntity
import java.util.*

@Repository
class TicketRepository(
    private val webClient: WebClient
) {
    suspend fun findTicketByTicketId(ticketId: UUID): Ticket? = webClient
        .get()
        .uri("tickets/$ticketId")
        .retrieve()
        .toEntity<Ticket>()
        .awaitSingle()
        .body
}