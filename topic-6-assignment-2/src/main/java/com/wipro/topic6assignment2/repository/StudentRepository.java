package com.wipro.topic6assignment2.repository;

import com.wipro.topic6assignment2.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByStudentTotalMarksGreaterThan(float mark);
}
