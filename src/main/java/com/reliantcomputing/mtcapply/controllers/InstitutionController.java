package com.reliantcomputing.mtcapply.controllers;

import com.reliantcomputing.mtcapply.models.Institution;
import com.reliantcomputing.mtcapply.services.InstitutionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/institutions")
public class InstitutionController {

    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping
    public Collection<Institution> getInstitutions(){
        return institutionService.getInstitutions();
    }

    @GetMapping("{id}")
    public ResponseEntity<Institution> getInstitution(@PathVariable final Long id){
        Optional<Institution> institutionOptional = institutionService.getInstitution(id);
        return institutionOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Institution addInstitution(@RequestBody final Institution institution){
        return institutionService.addInstitution(institution);
    }

    @PutMapping("{id}")
    public ResponseEntity<Institution> updateInstitution(@PathVariable final Long id, @RequestBody final Institution newInstitution){
        Institution institution = institutionService.updateInstitution(id, newInstitution);
        if(institution == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(institution);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteInstitution(@PathVariable final Long id){
        Optional<Institution> institutionOptional = institutionService.getInstitution(id);
        if (institutionOptional.isPresent()){
            institutionService.deleteInstitution(institutionOptional.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
