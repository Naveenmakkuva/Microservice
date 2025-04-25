package com.practice.department_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.department_service.model.DepartmentModel;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long>{

}
