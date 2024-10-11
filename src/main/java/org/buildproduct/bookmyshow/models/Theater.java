package org.buildproduct.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private String name;
    @ManyToOne
    private City city;
    private String address;
    @OneToMany
    private List<Screen> screens;

}


/*
* Theater ------  City (1 to 1)
* but city can have multiple theaters therefore many to one
*
* Theater ------ Screen (1 to many)
* and one screen can be in one theater only
*
*
* */