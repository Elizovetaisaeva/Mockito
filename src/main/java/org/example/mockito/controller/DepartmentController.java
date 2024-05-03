package org.example.mockito.controller;

import org.example.mockito.service.DepartmentService;
import org.example.mockito.service.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{id}/salary/sum")
    public Employee getSum(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeeSalarySum(departmentId);
    }

    @GetMapping("/{id}/salary/max")
    public double getMax(@PathVariable("id") int department) {
        return departmentService.getEmployeeMaxSalary(department);
    }

    @GetMapping("{id}/salary/min")
    public double getMin(@PathVariable("id") int department) {
        return departmentService.getEmployeeMinSalary(department);
    }

    @GetMapping(value = "/{id}/employees")
    public java.util.List<Employee> getAll(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);

    }
    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployees() {
        return departmentService.getEmployeesGrouped();
    }
}