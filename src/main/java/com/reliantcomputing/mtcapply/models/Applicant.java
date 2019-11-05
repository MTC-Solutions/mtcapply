package com.reliantcomputing.mtcapply.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "applicant")
    private ResidentialAddress residentialAddress;

    @OneToOne(mappedBy = "applicant")
    private PersonalDetails personalDetails;

    @OneToMany(mappedBy = "applicant")
    List<Document> documents = new ArrayList<>();
}
