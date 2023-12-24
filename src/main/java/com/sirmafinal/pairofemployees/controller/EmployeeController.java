package com.sirmafinal.pairofemployees.controller;

import com.sirmafinal.pairofemployees.model.Employee;
import com.sirmafinal.pairofemployees.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String listEmployees(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        System.out.println("employees size"+employees.size());
        return  "employees";
    }

    @GetMapping("/employee/add")
    public String addEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employeeEdit";
    }

    @PostMapping("/employee/add")
    @Validated
    public String addEmployee(@Valid @ModelAttribute Employee employee, BindingResult result, Model model, HttpServletRequest request){
        System.out.println("Request Parameters: " + request.getParameterMap());
        if(result.hasErrors()){
            System.out.println("record id" + employee.getId());
            return "employeeEdit";
        }

        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/employee/edit/{id}")
    public String editEmployeeForm(@PathVariable int id, Model model){
        try{
            model.addAttribute("employee", employeeService.findById(id));
        } catch (Exception exception){
            model.addAttribute("error", exception.getMessage());
            return "redirect:/";
        }
        return "employeeEdit";
    }

    @PostMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable int id, @Valid @ModelAttribute Employee employee, BindingResult result, Model model){
        if(result.hasErrors()){
            return "employeeEdit";
        }

        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/displayResults")
    public String displayResults(Model model) {
        model.addAttribute("commonProjects", employeeService.winnerCommonProjects());
        model.addAttribute("winnerPair", employeeService.getWinnerPair());
        return "winnerPair";
    }

}
