package com.sirmafinal.pairofemployees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements DataReader {
    @Override
    public List<Employee> readData(String filename) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(", ");
                int empID = Integer.parseInt(data[0]);
                int projectID = Integer.parseInt(data[1]);

                LocalDate dateFrom = LocalDate.parse(data[2]);//parseDate(data[2]);
                LocalDate dateTo = (data[3].equalsIgnoreCase("NULL")) ? LocalDate.now() : LocalDate.parse(data[3]); //parseDate(data[3]);

                employees.add(new Employee(empID, projectID, dateFrom, dateTo));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return employees;
    }
}
