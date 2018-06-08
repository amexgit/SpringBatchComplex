package com.cts.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	Optional<Employee> findById(Long id);
}
