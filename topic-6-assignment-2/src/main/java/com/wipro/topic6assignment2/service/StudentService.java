package com.wipro.topic6assignment2.service;

import com.wipro.topic6assignment2.domain.Student;
import com.wipro.topic6assignment2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> findByMarkGreater(float mark) {
        return studentRepository.findByStudentTotalMarksGreaterThan(mark);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Student student) {
        Optional<Student> existingOptional = studentRepository.findById(student.getStudentId());
        if(!existingOptional.isPresent()) {
            throw new EntityNotFoundException();
        }
        Student existing = existingOptional.get();
        existing.setStudentName(student.getStudentName());
        existing.setStudentClass(student.getStudentClass());
        existing.setStudentTotalMarks(student.getStudentTotalMarks());
        return studentRepository.save(existing);
    }

    public Student delete(String id) {
        Optional<Student> existingOptional = studentRepository.findById(id);
        if(!existingOptional.isPresent()) {
            throw new EntityNotFoundException();
        }
        Student existing = existingOptional.get();
        studentRepository.delete(existing);
        return existing;
    }
}
