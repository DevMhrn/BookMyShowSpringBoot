package org.buildproduct.bookmyshow.repositories;

import org.buildproduct.bookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    public Ticket save(Ticket ticket);



}
