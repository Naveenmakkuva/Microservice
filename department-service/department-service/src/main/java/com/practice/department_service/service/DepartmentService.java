package com.practice.department_service.service;

import java.util.List;

import com.practice.department_service.model.DepartmentModel;

public interface DepartmentService {

	public DepartmentModel addDepartment(DepartmentModel department);

	public DepartmentModel findById(Long id);

	public List<DepartmentModel> findAllDepartments();

}
