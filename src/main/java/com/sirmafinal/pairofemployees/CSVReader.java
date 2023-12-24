package com.sirmafinal.pairofemployees;

import com.sirmafinal.pairofemployees.model.Employee;
import com.sirmafinal.pairofemployees.service.EmployeeService;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class CSVReader implements DataReader {
    private EmployeeService employeeService;
    @Override
    public List<Employee> readData(String filename) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                int empId = Integer.parseInt(data[0]);
                int projectId = Integer.parseInt(data[1]);

                LocalDate dateFrom = LocalDate.parse(data[2]);//parseDate(data[2]);
                LocalDate dateTo = (data[3].equalsIgnoreCase("NULL")) ? LocalDate.now() : LocalDate.parse(data[3]); //parseDate(data[3]);

                employees.add(new Employee(empId, projectId, dateFrom, dateTo));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return employees;
    }
}
