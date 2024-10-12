package org.buildproduct.bookmyshow.dtos.TicketDtos;

import lombok.Getter;
import lombok.Setter;
import org.buildproduct.bookmyshow.dtos.ResponseStatus;
import org.buildproduct.bookmyshow.models.Ticket;

@Getter
@Setter
public class BookTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;

}
