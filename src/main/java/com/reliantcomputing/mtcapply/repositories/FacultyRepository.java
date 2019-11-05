package com.reliantcomputing.mtcapply.repositories;

import com.reliantcomputing.mtcapply.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
