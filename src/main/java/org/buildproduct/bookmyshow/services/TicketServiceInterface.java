package org.buildproduct.bookmyshow.services;

import org.buildproduct.bookmyshow.models.Ticket;

import java.util.List;

public interface TicketServiceInterface {

    Ticket bookTicket(Long userId, List<Long> showSeatIds);

}
