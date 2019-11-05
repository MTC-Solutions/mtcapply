package com.reliantcomputing.mtcapply.models;

import javax.persistence.*;

@Entity
public class ResidentialAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String province;
    private String city;
    private String streetName;
    private String postalCode;

    @OneToOne
    private Applicant applicant;
}
