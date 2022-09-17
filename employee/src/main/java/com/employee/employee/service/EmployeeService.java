package com.employee.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee.exception.UserNotFoundException;
import com.employee.employee.model.Employee;
import com.employee.employee.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;

@Service

public class EmployeeService {
	@Autowired
    EmployeeRepository empRepository;
	
	//TO CREATE 
	public Employee createEmployee(Employee emp) {
	    return empRepository.save(emp);
	}

	//TO READ
	public List<Employee> getEmployees() {
	    return empRepository.findAll();
	}
	
	//TO READ SINGLE EMPLOYEE
	public Optional<Employee> getEmployee(Long empId) throws UserNotFoundException {
		Optional<Employee> emp = empRepository.findById(empId);
		if(emp != null) {
			return emp;
		}else {
			throw new UserNotFoundException("Employee not found with Id: " + empId);
		}
	}

	//TO DELETE
	public void deleteEmployee(Long empId) {
	    empRepository.deleteById(empId);
	}
	
	//TO UPDATE
	public Employee updateEmployee(Long empId, Employee employeeDetails) {
	        Employee emp = empRepository.findById(empId).get();
	        emp.setFirstName(employeeDetails.getFirstName());
	        emp.setLastName(employeeDetails.getLastName());
	        emp.setEmailId(employeeDetails.getEmailId());
	        emp.setEmpRole(employeeDetails.getEmpRole());
	        emp.setMobileNo(employeeDetails.getMobileNo());
	        emp.setAge(employeeDetails.getAge());
	        
	        return empRepository.save(emp);                                
	}
}
