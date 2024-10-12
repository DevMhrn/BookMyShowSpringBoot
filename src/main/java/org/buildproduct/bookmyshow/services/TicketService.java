package org.buildproduct.bookmyshow.services;

import org.buildproduct.bookmyshow.models.*;
import org.buildproduct.bookmyshow.repositories.ShowSeatRepository;
import org.buildproduct.bookmyshow.repositories.TicketRepository;
import org.buildproduct.bookmyshow.repositories.UserRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.transaction.annotation.Isolation.*;

public class TicketService implements TicketServiceInterface {
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private TicketRepository ticketRepository;

    public TicketService(UserRepository userRepository, ShowSeatRepository showSeatRepository,
                         TicketRepository ticketRepository) {
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long userId, List<Long> showSeatIds) {
        /*

        1. Get all the User details from the database using the given userId.
        2. Get the show Seat details from the database using the given showSeatId.
        3. Check if all the seats selected by the users are available or not.
        4. Even if single seat among selected seat are not available the give a message or booking can't be done ;
        5. If all the seats are available then book the ticket for the user.



         */


        Optional<User> optionalUser  = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            //throw an exception and redirect themm to the signupp page or login page

            throw new RuntimeException("User with userId "+userId+" doesn't exist!! You must be a registered user to book a ticket");

        }

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                //throw an exception and redirect them to the show page
                throw new RuntimeException("Seat with seatId "+showSeat.getId()+" is not available! Please select another seat");
            }
        }

        //Payment Service

        //here will be the implementation of tickectStatus Blocked and conncurrently payment service will be called
        //for some limited time to make the payment


        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            showSeatRepository.save(showSeat);
        }


        Ticket ticket = new Ticket();
        ticket.setTicketNumber(String.valueOf(UUID.randomUUID()));
        ticket.setTicketStatus(TicketStatus.CONFIRMED);
        ticket.setUser(optionalUser.get());
        ticket.setTimestamp(new Date());
        ticket.setPayment(new Payment());
        ticket.setAmount(showSeats.size()*100);//assuming the price of each seat is 100

        return ticketRepository.save(ticket);


    }
}
