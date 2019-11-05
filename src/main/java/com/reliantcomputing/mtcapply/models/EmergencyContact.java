package com.reliantcomputing.mtcapply.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmergencyContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String initials;
    private String lastName;
    private String email;
    private String alternativeEmail;
    private String phoneNumber;
    private String alternativeNumber;
}
