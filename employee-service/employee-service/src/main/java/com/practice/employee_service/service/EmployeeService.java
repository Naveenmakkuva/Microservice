package com.practice.employee_service.service;

import java.util.List;

import com.practice.employee_service.model.EmployeeModel;
import com.practice.employee_service.model.ResponseVo;

public interface EmployeeService {

	public EmployeeModel addEmployee(EmployeeModel employee);

	public EmployeeModel getById(Long id);

	public List<EmployeeModel> findAllEmployees();

	public ResponseVo getEmployeeByDept(Long id);

}
