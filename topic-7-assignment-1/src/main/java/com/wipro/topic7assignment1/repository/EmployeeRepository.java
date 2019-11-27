package com.wipro.topic7assignment1.repository;

import com.wipro.topic7assignment1.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByEmpLocation(String location);
    List<Employee> findByEmpBand(String band);
}
