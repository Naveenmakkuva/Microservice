package com.practice.employee_service.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseVo {
	private EmployeeModel employeeModel;
	private DepartmentModel departmentModel;
}
