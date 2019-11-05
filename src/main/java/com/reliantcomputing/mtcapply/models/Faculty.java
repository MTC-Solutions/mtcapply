package com.reliantcomputing.mtcapply.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //RELATIONSHIP FACULTIES-INSTITUTION
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="institution_id", referencedColumnName = "id")
    private Institution institution;

    //RELATIONSHIP FACULTY-COURSES
    @OneToMany(mappedBy = "faculty")
    private List<Course> courses = new ArrayList<>();

    public Faculty() {
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

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
