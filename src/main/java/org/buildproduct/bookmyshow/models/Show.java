package org.buildproduct.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie; //needs movie to define the cardinality
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // only required when we have a list of enums
    private List<Feature> featureList;
    private String language;
}
/*
1.

Show ---- Movie => M:1
Show ---- Screen => M:1 // not at a time but one after another
Show ---- Feature => M:N


*/