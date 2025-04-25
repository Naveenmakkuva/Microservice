package com.practice.employee_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.employee_service.model.EmployeeModel;
import com.practice.employee_service.model.ResponseVo;
import com.practice.employee_service.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private static final String SERVICE_NAME = "employee-service";
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeModel> addEmployee(@RequestBody EmployeeModel employee) {
		return new ResponseEntity<EmployeeModel>(employeeService.addEmployee(employee), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeModel> getById(@PathVariable Long id){
		return new ResponseEntity<EmployeeModel>(employeeService.getById(id), HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeModel>> getAllEmployees(){
		return new ResponseEntity<List<EmployeeModel>>(employeeService.findAllEmployees(), HttpStatus.OK);
	}
	
//	internal communication between services using REST API.
//	Agenda to call department service and get all employees under that department along with employee details (id provided in API).
//	To achieve this, we created a Value Object vo responseVo combo of emp and depart model.
	

//	if we want to apply retry
//	@Retry(name = SERVICE_NAME,fallbackMethod = "employeeServiceFallbackMethod")
//	if we want to apply rate limiter
//	@RateLimiter(name = SERVICE_NAME, fallbackMethod = "employeeServiceFallbackMethod")
	@GetMapping("/dept/{id}")
	@CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "employeeServiceFallbackMethod")
	public ResponseEntity<ResponseVo> getEmployeeByDept(@PathVariable("id") Long id){
		return new ResponseEntity<ResponseVo>(employeeService.getEmployeeByDept(id), HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseVo> employeeServiceFallbackMethod(Exception e){
		return new ResponseEntity<ResponseVo>(new ResponseVo(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
