package com.sirmafinal.pairofemployees;
import java.util.List;

public interface DataReader {

    List<Employee> readData(String filename);
}
