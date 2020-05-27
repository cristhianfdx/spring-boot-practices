package com.cdgz.crudspringmvc.domain.repository;

import com.cdgz.crudspringmvc.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
