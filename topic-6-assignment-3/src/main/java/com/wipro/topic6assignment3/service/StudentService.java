package com.wipro.topic6assignment3.service;

import com.wipro.topic6assignment3.domain.Student;
import com.wipro.topic6assignment3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll(String id, float mark, String clazz) {
        Specification<Student> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(id != null && !"".equals(id.trim())) {
                predicates.add(criteriaBuilder.equal(root.get("studentId"), id));
            }
            if(mark != 0) {
                predicates.add(criteriaBuilder.greaterThan(root.get("studentTotalMarks"), mark));
            }
            if(clazz != null && !"".equals(clazz.trim())) {
                predicates.add(criteriaBuilder.equal(root.get("studentClass"), clazz));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        };
        return studentRepository.findAll(specification);
    }

    public Student findById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> findByMarkGreater(float mark) {
        return studentRepository.findByStudentTotalMarksGreaterThan(mark);
    }

    public List<Student> findByClass(String clazz) {
        return studentRepository.findByStudentClass(clazz);
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
