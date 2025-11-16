package dev.slne.surf.data.test.paper.ticket

import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange
import java.util.*

@Repository
interface TicketRepository {
    @GetExchange("tickets/{ticketId}")
    suspend fun findTicketByTicketId(
        @PathVariable ticketId: UUID
    ): Ticket?
}