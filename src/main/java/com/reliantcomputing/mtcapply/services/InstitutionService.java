package com.reliantcomputing.mtcapply.services;

import com.reliantcomputing.mtcapply.models.Institution;
import com.reliantcomputing.mtcapply.repositories.InstitutionRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    //GET ALL INSTITUTIONS
    public Collection<Institution> getInstitutions(){
        return institutionRepository.findAll();
    }

    //GET INSTITUTION
    public Optional<Institution> getInstitution(final Long id){
        return institutionRepository.findById(id);
    }

    //ADD INSTITUTION
    public Institution addInstitution(final Institution institution){
        return institutionRepository.save(institution);
    }

    //UPDATE INSTITUTION
    public Institution updateInstitution(final Long id, final Institution newInstitution){
        Optional<Institution> institutionOptional = institutionRepository.findById(id);

        if (institutionOptional.isPresent()){
            Institution institution = institutionOptional.get();
            institution.setName(newInstitution.getName());
            return institutionRepository.save(institution);
        }

        return null;
    }

    //DELETE INSTITUTION
    public void deleteInstitution(final Institution institution){
        institutionRepository.delete(institution);
    }
}
