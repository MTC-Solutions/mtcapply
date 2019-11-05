package com.reliantcomputing.mtcapply.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String firstName;
    private String middleName;
    private String preferredName;
    private String lastName;

    private String gender;
    private String dateOfBirth;
    private String idNumber;

    private String maritalStatus;

    @OneToOne
    private Applicant applicant;
}
