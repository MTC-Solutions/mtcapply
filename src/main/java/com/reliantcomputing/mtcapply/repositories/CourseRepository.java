package com.reliantcomputing.mtcapply.repositories;

import com.reliantcomputing.mtcapply.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CourseRepository extends JpaRepository<Course, Long> {
}
