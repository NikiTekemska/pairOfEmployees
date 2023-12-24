package com.sirmafinal.pairofemployees.service;

import com.sirmafinal.pairofemployees.model.CommonProjects;
import com.sirmafinal.pairofemployees.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
@Service
public class CommonProjectService {
    @Autowired
    private EmployeeService employeeService;
    public List<CommonProjects> getCommonProjects() {
        List<Employee> employees = employeeService.findAll();
        List<CommonProjects> commonProjects = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            Employee emp1 = employees.get(i);
            for (int j = i + 1; j < employees.size(); j++) {
                Employee emp2 = employees.get(j);
                if (emp1.getEmpId() != emp2.getEmpId() && emp1.getProjectId() == emp2.getProjectId()) {
                    if (emp1.getStartDate().isBefore(emp2.getEndDate()) || emp2.getStartDate().isBefore(emp1.getEndDate())) {
                        //TODO if the startDates are the same and endDates too
                        LocalDate periodStart = (emp1.getStartDate().isBefore(emp2.getStartDate()) ? emp2.getStartDate() : emp1.getStartDate());
                        LocalDate periodEnd = (emp1.getEndDate().isBefore(emp2.getEndDate()) ? emp1.getEndDate() : emp2.getEndDate());
                        long duration = ChronoUnit.DAYS.between(periodStart, periodEnd);    //using ChronoUnit because is more accurate, it is considering leap year & daylight saving time changes
                        commonProjects.add(new CommonProjects(emp1.getEmpId(), emp2.getEmpId(), emp1.getProjectId(), duration));
                    }
                }
            }
        }
        return commonProjects;
    }

    public CommonProjects getWinnerPair() {
        List<CommonProjects> commonProjects = getCommonProjects();
        long longestPeriod = 0;
        CommonProjects winnerPair = null;

        for (int i = 0; i < commonProjects.size(); i++) {
            CommonProjects prj1 = commonProjects.get(i);
            long sumOfAllCommonPrj = prj1.getDuration();
            for (int j = i + 1; j < commonProjects.size(); j++) {
                CommonProjects prj2 = commonProjects.get(j);
                if ((prj1.getEmp1ID() == prj2.getEmp1ID() && prj1.getEmp2ID() == prj2.getEmp2ID()) || (prj1.getEmp1ID() == prj2.getEmp2ID() && prj1.getEmp2ID() == prj2.getEmp1ID())) {
                    sumOfAllCommonPrj += prj2.getDuration();
                }
            }
            if (sumOfAllCommonPrj > longestPeriod) {
                longestPeriod = sumOfAllCommonPrj;
                winnerPair = prj1;
            } //TODO if the sum is equal to the longestPeriod
        }
        return winnerPair;
    }

    public List<CommonProjects> winnerCommonProjects(){
        List<CommonProjects> winnerProjects= new ArrayList<>();
        List<CommonProjects> commonProjects =getCommonProjects();
        CommonProjects winnerPair = getWinnerPair();
        for(CommonProjects project : commonProjects){
            if(project.getEmp1ID() == winnerPair.getEmp1ID() && project.getEmp1ID() == winnerPair.getEmp1ID()){
                winnerProjects.add(project);
            }
        }
        return winnerProjects;
    }
}
