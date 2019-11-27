package com.wipro.topic7assignment1.service;

import com.wipro.topic7assignment1.domain.Employee;
import com.wipro.topic7assignment1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findByLocation(String location) {
        return employeeRepository.findByEmpLocation(location);
    }

    public List<Employee> findByBand(String band) {
        return employeeRepository.findByEmpBand(band);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee) {
        Optional<Employee> existingOptional = employeeRepository.findById(employee.getEmpId());
        if(!existingOptional.isPresent()) {
            throw new EntityNotFoundException();
        }
        Employee existing = existingOptional.get();
        existing.setEmpFirstName(employee.getEmpFirstName());
        existing.setEmpLastName(employee.getEmpLastName());
        existing.setEmpLocation(employee.getEmpLocation());
        existing.setEmpBand(employee.getEmpBand());
        return employeeRepository.save(existing);
    }
}
