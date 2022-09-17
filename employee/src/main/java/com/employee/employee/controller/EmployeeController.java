package com.employee.employee.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.exception.UserNotFoundException;
import com.employee.employee.model.Employee;
import com.employee.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	 @Autowired
     EmployeeService empService;
	 
	 @RequestMapping(value="/employees", method=RequestMethod.POST)
	 public Employee createEmployee(@RequestBody @Valid Employee emp) {
	     return empService.createEmployee(emp);
	 }
	 
	 @RequestMapping(value="/employees", method=RequestMethod.GET)
	 public List<Employee> readEmployees() {
	     return empService.getEmployees();
	 }
	 
	 @GetMapping("/employees/{empId}")
	 public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable long empId) throws UserNotFoundException{
		 return ResponseEntity.ok(empService.getEmployee(empId));
	 }

	 @RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
	 public Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
	     return empService.updateEmployee(id, empDetails);
	 }

	 @RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
	 public void deleteEmployees(@PathVariable(value = "empId") Long id) {
	     empService.deleteEmployee(id);
	 }
}
