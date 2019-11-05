package com.reliantcomputing.mtcapply.repositories;

import com.reliantcomputing.mtcapply.models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
