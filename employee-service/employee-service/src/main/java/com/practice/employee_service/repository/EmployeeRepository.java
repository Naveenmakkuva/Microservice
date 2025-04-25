package com.practice.employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.employee_service.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{

}
