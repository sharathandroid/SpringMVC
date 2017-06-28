package com.sharath.spring.mvc.Service;

import java.sql.Date;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sharath.spring.mvc.DAO.EmployeeOperations;
import com.sharath.spring.mvc.Model.Employee;
import com.sharath.spring.mvc.repo.IEmployeeDAO;
@Service
@Component
public class EmployeeService{
	private static final Logger logger=org.slf4j.LoggerFactory.getLogger(EmployeeService.class);
	@Autowired
	EmployeeOperations employeeOperations;
//	@Autowired
	//EmployeeRepository employeeRepository;
	@Autowired
	IEmployeeDAO employeedao;
	public Employee getEmployeeInfo(int empNo) throws SQLException{
		Employee emp=employeedao.getEmployeeById(empNo);
		return emp;
		
	}

	public void addEmpInfo(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
//		employeeRepository.save(new Employee(employeeId, birthDate, firstName, lastName, gender, hiredDate, salary));
		logger.debug("2");
		logger.debug(employee.getFirstName());
		employeedao.addEmployee(employee);
	}

	public void updateEmpInfo(int employeeId, String firstName, String lastName, String gender, Date birthDate,
			Date hireDate) throws SQLException {
		// TODO Auto-generated method stub
		employeeOperations.updateEmployee(employeeId,firstName,lastName,gender,birthDate,hireDate );
	}

	
}
