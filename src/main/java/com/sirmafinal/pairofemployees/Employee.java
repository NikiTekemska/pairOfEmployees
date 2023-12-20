package com.sirmafinal.pairofemployees;

import java.time.LocalDate;

class Employee {
   private int empID;
   private int projectID;
   private LocalDate startDate;
   private LocalDate endDate;

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
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

    public void setEndDate(LocalDate dateTo) {
        this.endDate = dateTo;
    }

    public Employee(int empID, int projectID, LocalDate dateFrom, LocalDate dateTo) {
        this.empID = empID;
        this.projectID = projectID;
        this.startDate = dateFrom;
        this.endDate = dateTo;
    }
}