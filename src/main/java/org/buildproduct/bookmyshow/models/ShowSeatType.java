package org.buildproduct.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    //class to store the price of the seat type
    private Show show;
    private SeatType seatType;
    private int price;

}
