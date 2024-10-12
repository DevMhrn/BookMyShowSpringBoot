package org.buildproduct.bookmyshow.dtos.TicketDtos;

import lombok.Getter;
import lombok.Setter;
import org.buildproduct.bookmyshow.models.ShowSeat;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private Long userId;
    private List<Long> showSeatIds;

}
