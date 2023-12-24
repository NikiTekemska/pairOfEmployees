package com.sirmafinal.pairofemployees.repository;

import com.sirmafinal.pairofemployees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonProjectRepository extends JpaRepository<Employee, Integer> {

}
