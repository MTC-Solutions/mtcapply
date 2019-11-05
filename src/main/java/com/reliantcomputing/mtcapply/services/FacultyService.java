package com.reliantcomputing.mtcapply.services;

import com.reliantcomputing.mtcapply.models.Faculty;
import com.reliantcomputing.mtcapply.models.Institution;
import com.reliantcomputing.mtcapply.repositories.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final InstitutionService institutionService;

    public FacultyService(FacultyRepository facultyRepository, InstitutionService institutionService) {
        this.facultyRepository = facultyRepository;
        this.institutionService = institutionService;
    }

    public Collection<Faculty> getFaculties(final Long institutionID){
        Optional<Institution> institutionOptional = institutionService.getInstitution(institutionID);

        return institutionOptional
                .<Collection<Faculty>>map(Institution::getFaculties)
                .orElse(null);
    }

    public Optional<Faculty> getFaculty(final Long id){
        return facultyRepository.findById(id);
    }

    public Faculty addFaculty(final Long institutionID, final Faculty faculty){
        Optional<Institution> institutionOptional = institutionService.getInstitution(institutionID);
        if (institutionOptional.isPresent()){
            List<Faculty> faculties = new ArrayList<>();
            faculties.add(faculty);
            institutionOptional.get().setFaculties(faculties);
            return facultyRepository.save(faculty);
        }

        return null;
    }

    public Faculty updateFaculty(final Long id, final Faculty newFaculty){
        Optional<Faculty> facultyOptional = facultyRepository.findById(id);
        if (facultyOptional.isPresent()){
            Faculty faculty = facultyOptional.get();
            faculty.setName(newFaculty.getName());
            return facultyRepository.save(faculty);
        }

        return null;
    }

    public void deleteFaculty(final Faculty faculty){
        facultyRepository.delete(faculty);
    }
}
