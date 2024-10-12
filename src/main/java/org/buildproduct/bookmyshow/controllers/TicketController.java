package org.buildproduct.bookmyshow.controllers;

import org.buildproduct.bookmyshow.dtos.ResponseStatus;
import org.buildproduct.bookmyshow.dtos.TicketDtos.BookTicketRequestDto;
import org.buildproduct.bookmyshow.dtos.TicketDtos.BookTicketResponseDto;
import org.buildproduct.bookmyshow.models.Ticket;
import org.buildproduct.bookmyshow.services.TicketService;
import org.springframework.web.bind.annotation.RequestBody;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public BookTicketResponseDto bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto) {
        BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();
        try{

            Ticket ticket = ticketService.bookTicket(
                    bookTicketRequestDto.getUserId(), bookTicketRequestDto.getShowSeatIds());
            bookTicketResponseDto.setTicket(ticket);
            bookTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }


        catch (Exception e){
            // Handle exception
            bookTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        // Book ticket logic

        return bookTicketResponseDto;


    }

}
