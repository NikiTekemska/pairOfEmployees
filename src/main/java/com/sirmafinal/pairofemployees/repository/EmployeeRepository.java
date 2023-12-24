package com.sirmafinal.pairofemployees.repository;


import com.sirmafinal.pairofemployees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

