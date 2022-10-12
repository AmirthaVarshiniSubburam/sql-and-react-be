package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.DepartmentAlreadyExistsException;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;


@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class DepartmentController {

	@Autowired
	DepartmentService deptServ;
	
	@PostMapping("/department")
	public ResponseEntity<Department> savedepartment(@RequestBody Department department) throws DepartmentAlreadyExistsException {
		Department savedDepartment = deptServ.saveDepartment(department);
		return new ResponseEntity<Department>(savedDepartment, HttpStatus.CREATED);
	} 
	
	@GetMapping("/department/{deptid}")
	public ResponseEntity<Department> findADepartemt(@PathVariable int deptid) throws DepartmentNotFoundException {
		Department department = deptServ.findADepartment(deptid);
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}
	
	@GetMapping("/department")
	public ResponseEntity<List<Department>> findAllDepartments(){
		List<Department> departments = deptServ.findAllDepartment();
		return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
	}
	
	@PutMapping("/department")
	public ResponseEntity<Department> updateADepartment(@RequestBody Department department) throws DepartmentNotFoundException {
		Department updatedDepartment = deptServ.updateAnDepartment(department);
		return new ResponseEntity<Department>(updatedDepartment,HttpStatus.ACCEPTED);	
	}
	
	@DeleteMapping("/department")
	public String deleteADepartment(@RequestBody Department department) throws DepartmentNotFoundException {
		Department deletedDepartment = deptServ.deleteAnDepartment(department);
		return deletedDepartment.toString() + "is removed";
		
	}
	
}
