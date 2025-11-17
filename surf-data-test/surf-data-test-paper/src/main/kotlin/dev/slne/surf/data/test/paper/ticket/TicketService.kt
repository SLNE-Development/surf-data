package dev.slne.surf.data.test.paper.ticket

import org.springframework.stereotype.Component
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import java.util.*

@Component
class TicketService(
    val webClientFactory: HttpServiceProxyFactory
) {
    private val ticketRepository by lazy {
        webClientFactory.createClient(TicketRepository::class.java)
    }

    suspend fun getTicketByTicketId(ticketId: UUID) =
        ticketRepository.findTicketByTicketId(ticketId)
}