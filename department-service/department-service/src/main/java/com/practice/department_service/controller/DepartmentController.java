package com.practice.department_service.controller;

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

import com.practice.department_service.model.DepartmentModel;
import com.practice.department_service.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/add")
	public ResponseEntity<DepartmentModel> addDepartment(@RequestBody DepartmentModel department) {
		return new ResponseEntity<DepartmentModel>(departmentService.addDepartment(department), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentModel> getById(@PathVariable("id") Long id){
		return new ResponseEntity<DepartmentModel>(departmentService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<DepartmentModel>> getAllDepartments(){
		return new ResponseEntity<List<DepartmentModel>>(departmentService.findAllDepartments(), HttpStatus.OK);
	}

	
}
