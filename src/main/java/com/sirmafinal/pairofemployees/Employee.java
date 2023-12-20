package com.sirmafinal.pairofemployees;

import java.time.LocalDate;

class Employee {
    int empID;
    int projectID;
    LocalDate dateFrom;
    LocalDate dateTo;

    public Employee(int empID, int projectID, LocalDate dateFrom, LocalDate dateTo) {
        this.empID = empID;
        this.projectID = projectID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}