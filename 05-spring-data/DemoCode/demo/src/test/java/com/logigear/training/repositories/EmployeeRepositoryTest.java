package com.logigear.training.repositories;

import com.logigear.training.entities.Employee;
import com.logigear.training.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void isEmployeeRepositoyInjected() {
        assertThat(employeeRepository).isNotNull();
    }

    @Test
    void insertEmployeeTest() {
        Employee employee = new Employee("test", "passwordTest", "testUser", "test");
        employeeRepository.save(employee);

        Optional<Employee> employeeFound = employeeRepository.findById("test1");

        assertThat(employee).isNotNull();
        assertThat(employeeFound).isNotNull();
    }

    @Test
    void findAllEmployeeTest() {
        for (int i = 1; i <= 10; i++) {
            Employee employee = new Employee("test" + i, "passwordTest", "testUser", "test");
            employeeRepository.saveAndFlush(employee);
        }
        assertEquals(10, employeeRepository.findAll().size());
    }

    @Test
    void updateEmployeeTest() {
        Employee employee = new Employee("test", "passwordTest", "testUser", "test");
        employeeRepository.save(employee);

        employee.setFullname("RenamedTestUser");
        employee.setRole("RoleTest");
        employeeRepository.save(employee);

        Optional<Employee> employeeFound = employeeRepository.findById("test");

        assertThat(employeeFound).isNotNull();
        assertEquals(employeeFound.get().getFullname(),"RenamedTestUser");
    }
}
