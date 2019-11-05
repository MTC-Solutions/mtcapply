package com.reliantcomputing.mtcapply.models;

import javax.persistence.*;

@Entity
public class ApplicantContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String alternativeEmail;
    private String phoneNumber;
    private String alternativeNumber;
}
