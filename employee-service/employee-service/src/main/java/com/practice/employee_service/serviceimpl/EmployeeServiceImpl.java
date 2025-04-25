package com.practice.employee_service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practice.employee_service.model.DepartmentModel;
import com.practice.employee_service.model.EmployeeModel;
import com.practice.employee_service.model.ResponseVo;
import com.practice.employee_service.repository.EmployeeRepository;
import com.practice.employee_service.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RestTemplate restTemplate;

	private static final String BASE_URL = "http://localhost:8082/departments/";

	@Override
	public EmployeeModel addEmployee(EmployeeModel employee) {
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public EmployeeModel getById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public List<EmployeeModel> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public ResponseVo getEmployeeByDept(Long id) {
		ResponseVo response = new ResponseVo();
		EmployeeModel employee = employeeRepository.findById(id).get();
		
		String url = BASE_URL+employee.getDepartmentId();
		DepartmentModel department = restTemplate.getForObject(url, DepartmentModel.class);
		response.setEmployeeModel(employee);
		response.setDepartmentModel(department);
		return response;
	}

}
