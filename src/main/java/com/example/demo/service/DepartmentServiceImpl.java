package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.DepartmentAlreadyExistsException;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.repositary.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository deptRepo;
	
	@Override
	public Department saveDepartment(Department department) throws DepartmentAlreadyExistsException {
		if(deptRepo.existsById(department.getDeptId())) {
			throw new DepartmentAlreadyExistsException("Department Already Exists...");
		}
		return deptRepo.save(department);
	}

	@Override
	public Department findADepartment(int id) throws DepartmentNotFoundException {
		if(deptRepo.existsById(id)) {
			throw new DepartmentNotFoundException("Department Not Found..");
		}
		return deptRepo.findById(id).get() ;
	}

	@Override
	public List<Department> findAllDepartment() {
		return deptRepo.findAll();
	}

	@Override
	public Department updateAnDepartment(Department department) throws DepartmentNotFoundException {
		if(!deptRepo.existsById(department.getDeptId())) {
			throw new DepartmentNotFoundException("Department Not Found...");
		}
		return deptRepo.save(department);
	}

	@Override
	public Department deleteAnDepartment(Department department) throws DepartmentNotFoundException {
		if(!deptRepo.existsById(department.getDeptId())) {
			throw new DepartmentNotFoundException("Department Not Found..");
		}
		Department deleteDepartment = department;
		deptRepo.delete(department);
		return deleteDepartment;
	}

}
