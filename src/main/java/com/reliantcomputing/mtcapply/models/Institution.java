package com.reliantcomputing.mtcapply.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //RELATIONSHIP INSTITUTION-CAMPUS
    @OneToMany(mappedBy = "institution")
    private List<Campus> campuses = new ArrayList<>();

    //RELATIONSHIP INSTITUTION-FACULTY
    @OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
    private List<Faculty> faculties = new ArrayList<>();

    public Institution() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Campus> getCampuses() {
        return campuses;
    }

    public void setCampuses(List<Campus> campuses) {
        this.campuses = campuses;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
