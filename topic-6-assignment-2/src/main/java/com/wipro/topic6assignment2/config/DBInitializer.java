package com.wipro.topic6assignment2.config;

import com.wipro.topic6assignment2.domain.Student;
import com.wipro.topic6assignment2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        studentRepository.deleteAll();

        studentRepository.save(new Student("S001", "Steve Martin", "C1", 90));
        studentRepository.save(new Student("S002", "Michel Jackson", "C1", 80));
        studentRepository.save(new Student("S003", "Shakira", "C2", 86));
        studentRepository.save(new Student("S004", "George Michael", "C1", 67));
        studentRepository.save(new Student("S005", "Skrillex", "C3", 59));
        studentRepository.save(new Student("S006", "Madona", "C3", 76));
        studentRepository.save(new Student("S007", "Anderson Davis", "C2", 99));
    }
}
