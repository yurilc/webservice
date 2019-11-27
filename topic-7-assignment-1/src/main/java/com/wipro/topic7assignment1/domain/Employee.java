package com.wipro.topic7assignment1.domain;

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
public class Employee {
    @XmlElement
    @Id
    private String empId;
    @XmlElement
    private String empFirstName;
    @XmlElement
    private String empLastName;
    @XmlElement
    private String empLocation;
    @XmlElement
    private String empBand;

    public Employee() {
    }

    public Employee(String empId, String empFirstName, String empLastName, String empLocation, String empBand) {
        this.empId = empId;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empLocation = empLocation;
        this.empBand = empBand;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpLocation() {
        return empLocation;
    }

    public void setEmpLocation(String empLocation) {
        this.empLocation = empLocation;
    }

    public String getEmpBand() {
        return empBand;
    }

    public void setEmpBand(String empBand) {
        this.empBand = empBand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId.equals(employee.empId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", empLocation='" + empLocation + '\'' +
                ", empBand='" + empBand + '\'' +
                '}';
    }
}