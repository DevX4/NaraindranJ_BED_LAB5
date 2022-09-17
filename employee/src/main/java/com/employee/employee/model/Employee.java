package com.employee.employee.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="emp_id")
         private Long id;
     
	 @NotNull(message="First name cannot be empty")
     @Column(name="first_name")
     private String firstName;
     
	 @NotNull(message="Last name cannot be empty")
     @Column(name="last_name")
     private String lastName;
     
	 @NotNull(message="Role cannot be empty")
     @Column(name="emp_role")
     private String empRole;
     
	 @Email(message="Invalid email ID")
     @Column(name="email_id")
     private String emailId;
     
	 @Pattern(regexp="^\\d{10}$",message="Invalid mobiile nummber")
     @Column(name="mobile_num")
     private String mobileNo;
	 
	 @Min(18)
	 @Max(60)
	 @Column(name="age")
	 private int age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
