package org.example.mockito.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public double getEmployeesSalarySum(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSelary)
                .sum();

    }

    public double getEmployeeMaxSalary(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSelary)
                .max()
                .orElseThrow();
    }

    public double getEmployeeMinSalary(int department) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSelary)
                .min()
                .orElseThrow();

    }
    public List<Employee> getAll(int i){
        int department = 0;
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
}
    public Map<Integer, List<Employee>> getEmployeesGrouped(){
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Employee getEmployeeSalarySum(int departmentId) {
        return null;

    }

    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return List.of();
    }

    public Map<Integer, List<Employee>> getAll() {
        return null;
    }
}