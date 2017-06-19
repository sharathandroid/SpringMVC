package com.sharath.spring.mvc.Service;

import java.sql.Date;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sharath.spring.mvc.DAO.EmployeeOperations;
import com.sharath.spring.mvc.DAO.EmployeeOperationsImpl;
import com.sharath.spring.mvc.Model.Employee;
@Component
public class EmployeeService{
	@Autowired
	EmployeeOperations employeeOperations;
	
	
	public Employee getEmployeeInfo(int empNo) throws SQLException{
		Employee emp=employeeOperations.getEmployee(empNo );
		return emp;
		
	}

	public void addEmpInfo(int employeeId, String firstName, String lastName, String gender, Date birthDate,
			Date hiredDate, int salary) throws SQLException {
		// TODO Auto-generated method stub
		employeeOperations.addEmployee(employeeId, firstName, lastName, gender, birthDate, hiredDate, salary);
		
	}

	public void updateEmpInfo(int employeeId, String firstName, String lastName, String gender, Date birthDate,
			Date hireDate) throws SQLException {
		// TODO Auto-generated method stub
		employeeOperations.updateEmployee(employeeId,firstName,lastName,gender,birthDate,hireDate );
	}

}
