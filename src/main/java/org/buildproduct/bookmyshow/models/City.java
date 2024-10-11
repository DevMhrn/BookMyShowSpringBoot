package org.buildproduct.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class City extends BaseModel {
    private String name;
    private String pinCode;

    //private List<Theatre> theatres; // can be written here also
}
