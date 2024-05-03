package org.example.mockito.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeService {
    private static final int SIZE_LIMIT = 5;
    private final Map<String, Employee> employees = new HashMap<>(SIZE_LIMIT);


    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee add(Employee employee) throws EmployeeAlreadyAddedException {
        if (employees.size() >= SIZE_LIMIT) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(createKey(employee))) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(createKey(employee), employee);
        return employee;

    }

    public Employee find(String firstName, String lastNaime) {
        Employee employee = employees.get(createKey(firstName, lastNaime));
        if (employee == null) {
        }

        return employee;
    }

    public Employee remove(String firstName, String lastNaime) {
        return employees.remove(createKey(firstName, lastNaime));

    }

    private static String createKey(Employee employee) {
        return createKey(employee.getFirstName(), employee.getLastNaime());
    }

    private static String createKey(String firstName, String lastNaime) {
        return (firstName + lastNaime).toLowerCase();

    }

    public Employee add(String firstName, String lastName, int department) {
        return null;
    }
}


