package com.reliantcomputing.mtcapply.controllers;

import com.reliantcomputing.mtcapply.models.Faculty;
import com.reliantcomputing.mtcapply.services.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("institution/{institutionID}")
    public Collection<Faculty> getFaculties(@PathVariable final Long institutionID){
        return facultyService.getFaculties(institutionID);
    }

    @PostMapping("institution/{institutionID}")
    public Faculty addFaculty(@PathVariable final Long institutionID, @RequestBody final Faculty faculty){
        return facultyService.addFaculty(institutionID, faculty);
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable final Long id){
        Optional<Faculty> facultyOptional = facultyService.getFaculty(id);
        return facultyOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable final Long id, @RequestBody Faculty newFaculty){
        Faculty faculty = facultyService.updateFaculty(id, newFaculty);

        if (faculty == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(faculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteFaculty(@PathVariable final Long id){
        Optional<Faculty> facultyOptional = facultyService.getFaculty(id);
        if (facultyOptional.isPresent()){
            facultyService.deleteFaculty(facultyOptional.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
