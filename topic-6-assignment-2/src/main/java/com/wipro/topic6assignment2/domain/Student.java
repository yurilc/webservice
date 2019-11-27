package com.wipro.topic6assignment2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@Entity
@Table
public class Student {
    @XmlElement
    @Id
    private String studentId;
    @XmlElement
    private String studentName;
    @XmlElement
    private String studentClass;
    @XmlElement
    private float studentTotalMarks;

    public Student() {
    }

    public Student(String studentId, String studentName, String studentClass, float studentTotalMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentTotalMarks = studentTotalMarks;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public float getStudentTotalMarks() {
        return studentTotalMarks;
    }

    public void setStudentTotalMarks(float studentTotalMarks) {
        this.studentTotalMarks = studentTotalMarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student movie = (Student) o;
        return Objects.equals(studentId, movie.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", studentTotalMarks=" + studentTotalMarks +
                '}';
    }
}
