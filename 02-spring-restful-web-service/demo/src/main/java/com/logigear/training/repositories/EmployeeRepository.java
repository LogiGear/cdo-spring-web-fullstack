package com.logigear.training.repositories;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import com.logigear.training.entities.Employee;
import com.logigear.training.exception.EmployeeAlreadyExistsException;
import com.logigear.training.exception.EmployeeNotFoundException;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRepository {
    private List<Employee> list;

    public EmployeeRepository() {
        this.list = new ArrayList<Employee>();
        this.list.add(new Employee("admin", "admin", "Administrator", "Admin"));
    }

    public boolean add(Employee e) {
        if (getEmployeeByUsername(e.getUsername()) != null) {
            throw new EmployeeAlreadyExistsException();
        }
        return list.add(e);
    }

    public Employee getEmployeeByUsername(String username) {
        Employee emp = null;
		for (Employee employee : this.list) {
			if (employee.getUsername().equals(username)) {
				emp = employee;
			}
		}
        return emp;
    }

    public boolean delete(String username) {
    	boolean flag = false;
    	Employee e = getEmployeeByUsername(username);
    	if (e == null)
    		throw new EmployeeNotFoundException();
       	flag = this.list.remove(e);
        return flag;
    }

    public boolean update(Employee e, String username) {
        AtomicBoolean flag = new AtomicBoolean(false);
        this.list = list.stream().map(emp -> {
            if (emp.getUsername().equals(username)) {
                if (e.getPassword() != null) {
                    emp.setPassword(e.getPassword());
                }
                if (e.getFullname() != null) {
                    emp.setFullname(e.getFullname());
                }
                if (e.getRole() != null) {
                    emp.setRole(e.getRole());
                }
                flag.set(true);
                return emp;
            }
            return emp;
        }).collect(Collectors.toList());
        return flag.get();
    }

    public List<Employee> getAll() {
        return new LinkedList<>(this.list);
    }

    public List<Employee> findByLikeFullname(String search) {
        List<Employee> tmpList = new LinkedList<>();
        for (Employee employee : this.list) {
            if (employee.getFullname().contains(search)) {
                tmpList.add(employee);
            }
        }
        return tmpList;
    }

}
