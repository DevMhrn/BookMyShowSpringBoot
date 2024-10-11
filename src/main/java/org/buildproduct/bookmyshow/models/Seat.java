package org.buildproduct.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String name;
    private int rowNumber;
    private int columnNumber;
    private SeatType seatType;
}
