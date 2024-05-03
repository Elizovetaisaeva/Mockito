package org.example.mockito.service;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceTest {
    EmployeeService service = new EmployeeService();

    @Test
    void add_possitive() throws EmployeeAlreadyAddedException {
        Employee employee = new Employee("Name", "Listname",  1, 1);
        service.add(employee);
        Collection<Employee> actual = service.getAll();
        Employee actualEmployee = actual.iterator().next();
        assertEquals(employee.getFirstNeme(), actualEmployee.getFirstName());
        assertEquals(employee.getLastName(), actualEmployee.getLastName());

    }

    @Test
    void add_negative_size() throws EmployeeAlreadyAddedException {
        for (int i = 0; i < 5; i++) {
           char symbol = (char) ('a'+ i);
            service.add(new Employee("Name" + symbol, "Last", 1, 1));
        }
        assertThrows(EmployeeStorageIsFullException.class, () -> {
            service.add(new Employee("Name", "Last", 1, 1));
        });
    }

    @Test
    void add_negative_unique() throws EmployeeAlreadyAddedException {
        Employee employee = new Employee("Name", "Listname",  1, 1);
        service.add(employee);
        assertThrows(EmployeeAlreadyAddedException.class, () -> {
            service.add(employee);
        });
    }

    @Test
    void find() throws EmployeeAlreadyAddedException {
        Employee employee = new Employee("Sergei", "Ivanov", 1, 1);
        service.add(employee);
        Employee actual = service.find( "Sergei", "Ivanov");
        assertEquals(employee.getFirstName(), actual.gettFirstName());
        assertEquals(employee.getLastName(),  actual.getLastName());


    }

    @Test
    void remove() throws EmployeeAlreadyAddedException {
        Employee employee = new Employee("Sergei", "Ivanov", 1, 1);
        service.add(employee);
        assertEquals(1, service.getAll().size());
        service.remove("Sergei", "Ivanov");
        assertEquals(1, service.getAll().size());



    }

}
