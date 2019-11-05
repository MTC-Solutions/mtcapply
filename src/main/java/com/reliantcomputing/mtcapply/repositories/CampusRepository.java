package com.reliantcomputing.mtcapply.repositories;


import com.reliantcomputing.mtcapply.models.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CampusRepository extends JpaRepository<Campus, Long> {
}
