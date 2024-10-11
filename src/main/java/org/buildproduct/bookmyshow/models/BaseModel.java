package org.buildproduct.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id // Primary Key //Identity column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
/*
MappedSuperClass Annotation
1. No table is created for the class annotated with @MappedSuperclass.
2. The fields of the class annotated with @MappedSuperclass are inherited by the entity class.
3. All the attributes of mapped superclass will be present as a column in the entity class.
**/