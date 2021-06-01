package com.logigear.training.repositories;

import com.logigear.training.entities.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
	@Query("Select e FROM Employee e WHERE e.fullname like %?1%")
	Optional<List<Employee>> findEmployeeByLikeFullName(String searchName);
	@Override
	List<Employee> findAll();
	@Override
	List<Employee> findAllById(Iterable<String> strings);
	@Override
	<S extends Employee> S saveAndFlush(S entity);
	@Override
	<S extends Employee> S save(S entity);
}
