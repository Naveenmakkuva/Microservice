package com.practice.department_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.department_service.Repository.DepartmentRepository;
import com.practice.department_service.model.DepartmentModel;
import com.practice.department_service.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentModel addDepartment(DepartmentModel department) {
		departmentRepository.save(department);
		return department;
	}

	@Override
	public DepartmentModel findById(Long id) {
		return departmentRepository.findById(id).get();
	}
	
	@Override
	public List<DepartmentModel> findAllDepartments() {
		return departmentRepository.findAll();
	}

}
