package com.reliantcomputing.mtcapply.models;

import javax.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String path;

    @ManyToOne
    private Applicant applicant;
}
