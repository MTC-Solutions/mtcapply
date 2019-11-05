package com.reliantcomputing.mtcapply.repositories;

import com.reliantcomputing.mtcapply.models.auth.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
