package org.buildproduct.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private Date timestamp;
    private User user;
    private List<ShowSeat> showSeats;
    private int amount;
    private Payment payment;
    private TicketStatus ticketStatus;

}
