package com.reliantcomputing.mtcapply.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Tertiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String level;
    private String course;
    private String institution;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String typeOfStudy;
    private Double previousAverage;
}
