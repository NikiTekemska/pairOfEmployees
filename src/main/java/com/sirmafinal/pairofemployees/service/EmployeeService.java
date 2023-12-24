package com.sirmafinal.pairofemployees.service;

import com.sirmafinal.pairofemployees.CSVReader;
import com.sirmafinal.pairofemployees.DataReader;
import com.sirmafinal.pairofemployees.model.Employee;
import com.sirmafinal.pairofemployees.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DataReader reader;

    public boolean isDBEmpty() {
        if (employeeRepository.count() == 0) {
            return true;
        } else {
            return false;
        }
    }
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    public Employee findById(int id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id: " + id));
    }

    public Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }

    public void delete(int id) {
        boolean exists = employeeRepository.existsById(id);
        if (exists) {
            employeeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Invalid Id provided");
        }
    }

    @PostConstruct
    public List<Employee> processEmployeeData() {
        DataReader reader = new CSVReader();
        List<Employee> employees = reader.readData("C:\\Users\\Nikoleta\\IdeaProjects\\pairOfEmployees\\employeeProjects.csv");
        boolean isDBEmpty = isDBEmpty();
        List<Employee> fulfillDB = new ArrayList<>();

        if (isDBEmpty) {
            return employeeRepository.saveAll(employees);
        } else {
            List<Employee> employeesDB = findAll();
            for (Employee employee : employees) {
                boolean foundDuplicate = false;
                for (Employee employeeDB : employeesDB) {
                    if (employee.getEmpId() == employeeDB.getEmpId()
                            && employee.getProjectId() == employeeDB.getProjectId()
                            && employee.getStartDate().equals(employeeDB.getStartDate()) // Use equals for LocalDate
                            && employee.getEndDate().equals(employeeDB.getEndDate())) {
                        foundDuplicate = true;
                        break;
                    }
                }
                if (!foundDuplicate) {
                    fulfillDB.add(employee);
                }
            }
            return employeeRepository.saveAll(fulfillDB);
        }
    }
}
