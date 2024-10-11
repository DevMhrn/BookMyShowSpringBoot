package org.buildproduct.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private int amount;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
}
