package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.DepartmentAlreadyExistsException;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.model.Department;


public interface DepartmentService {
	
	public Department saveDepartment(Department department) throws DepartmentAlreadyExistsException;
	public Department findADepartment(int id) throws  DepartmentNotFoundException;
	public List<Department> findAllDepartment();
	public Department updateAnDepartment(Department department) throws DepartmentNotFoundException;
	public Department deleteAnDepartment(Department department) throws DepartmentNotFoundException;
	



}
