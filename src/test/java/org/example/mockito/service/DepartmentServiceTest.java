package org.example.mockito.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MokitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void init() {
        when(employeeService.getAll()).thenReturn(
                List.of(
                        new Employee("Sergei", "Ivanov", 1, 10000),
                        new Employee("Sergei", "Ivanov", 1, 20000),
                        new Employee("Ruslan", "Isaev", 2, 20000),
                        new Employee("Larisa", "Hasaeva", 2, 30000),
                        new Employee("Marina", "Saeva", 2, 35000)
                )
        );
    }

    @Test
    void sum() {
        assertEquals(30000, departmentService.getEmployeeSalarySum(1));
        assertEquals(65000, departmentService.getEmployeeSalarySum(2));
    }

    @Test
    void min() {
        assertEquals(10000, departmentService.getEmployeeMinSalary(1));
        assertEquals(30000, departmentService.getEmployeeMinSalary(2));
    }

    @Test
    void max() {
        assertEquals(20000, departmentService.getEmployeeMaxSalary(1));
        assertEquals(60000, departmentService.getEmployeeMaxSalary(2));
    }

    @Test
    void filter_by_department() {
        List<Employee> actual = departmentService.getAll(1);
        for (Employee employee : actual) {
            assertEquals(1, employee.getDepartment());
        }
    }
        @Test
                void get_grouped() {
            Map<Integer, List<Employee>> actual = departmentService.getAll();
            assertEquals(2, actual.keySet().size());
            assertTrue(actual.containsKey(1));
            assertTrue(actual.containsKey(2));
            assertEquals(2, actual.get(1).size());
            assertEquals(3, actual.get(2).size());
    }
}





