package com.wipro.topic6assignment3.repository;

import com.wipro.topic6assignment3.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {
    List<Student> findByStudentTotalMarksGreaterThan(float mark);
    List<Student> findByStudentClass(String clazz);
}
