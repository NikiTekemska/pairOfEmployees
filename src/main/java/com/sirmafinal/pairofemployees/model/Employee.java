package com.sirmafinal.pairofemployees.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   private int empId;
   private int projectId;
   private LocalDate startDate;
   private LocalDate endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empID) {
        this.empId = empId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate dateFrom) {
        this.startDate = dateFrom;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee(int id, int empId, int projectId, LocalDate dateFrom, LocalDate endDate) {
        this.id = id;
        this.empId = empId;
        this.projectId = projectId;
        this.startDate = dateFrom;
        this.endDate = endDate;
    }
    public Employee(int empId, int projectId, LocalDate dateFrom, LocalDate endDate) {
        this.empId = empId;
        this.projectId = projectId;
        this.startDate = dateFrom;
        this.endDate = endDate;
    }

    public Employee(){

    }
}