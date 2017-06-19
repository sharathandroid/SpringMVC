package com.sharath.spring.mvc.DAO;

import java.sql.Date;
import java.sql.SQLException;

import com.sharath.spring.mvc.Model.Employee;


public interface EmployeeOperations {
public  Employee getEmployee(int empNo) throws SQLException;

public void addEmployee(int employeeId, String firstName, String lastName, String gender, Date birthDate,
		Date hiredDate, int salary) throws SQLException;

public void updateEmployee(int employeeId, String firstName, String lastName, String gender, Date birthDate,
		Date hireDate) throws SQLException;

}

