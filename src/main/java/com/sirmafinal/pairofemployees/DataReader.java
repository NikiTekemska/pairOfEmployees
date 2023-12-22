package com.sirmafinal.pairofemployees;
import com.sirmafinal.pairofemployees.model.Employee;

import java.util.List;

public interface DataReader {

    List<Employee> readData(String filename);
}
