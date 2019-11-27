package com.wipro.topic7assignment1.config;

import com.wipro.topic7assignment1.domain.Employee;
import com.wipro.topic7assignment1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.deleteAll();

        employeeRepository.save(new Employee("EM001", "Peter","Parker", "London", "B1"));
        employeeRepository.save(new Employee("EM002", "Steve","Rogers", "USA", "B3"));
        employeeRepository.save(new Employee("EM003", "Hulk","Smash", "USA", "B2"));
        employeeRepository.save(new Employee("EM004", "Tony","Stark", "London", "B3"));
        employeeRepository.save(new Employee("EM005", "Natasha","Romanoff", "London", "B1"));
        employeeRepository.save(new Employee("EM006", "Logan","Wolverine", "Canada", "B3"));
        employeeRepository.save(new Employee("EM007", "Jean","Grey", "USA", "B2"));
        employeeRepository.save(new Employee("EM008", "Charles","Xavier", "USA", "B2"));
        employeeRepository.save(new Employee("EM009", "Star","Lord", "USA", "B1"));
    }
}
