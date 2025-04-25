package com.practice.department_service.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmployeeModel {
	private Long id;
	private String name;
	private Long DepartmentId;
	private Integer age;
	private String position;
}
