package org.buildproduct.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private String ticketNumber;
    private Date timestamp;
    @ManyToOne
    private User user;
    @OneToMany
    private List<ShowSeat> showSeats;
    private int amount;
    @OneToOne
    private Payment payment;
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

}
/*
* Ticket --- User (1 to 1)
* but one user can have multiple tickets therefore many to one
*
* Ticket --- ShowSeat (1 to many) )
* and one showSeat can be in one ticket only
*
* Ticket --- Payment (1 to 1)
* but one payment can have one ticket therefore many to one
*
*
* */
