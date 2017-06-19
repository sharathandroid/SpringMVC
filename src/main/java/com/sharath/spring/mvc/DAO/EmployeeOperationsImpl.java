package com.sharath.spring.mvc.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.sharath.spring.mvc.Model.Employee;


@Component
public class EmployeeOperationsImpl implements EmployeeOperations {
	static Connection connection;
	long time = System.currentTimeMillis();
	java.sql.Date date = new java.sql.Date(time);	
    {
        try {
            connection = createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public Employee getEmployee(int empNo) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement statement = connection.prepareStatement("select * from employees where emp_no=? ");
        statement.setInt(1,empNo);
 ResultSet resultSet = statement.executeQuery();
 PreparedStatement statement3 = connection.prepareStatement("select * from salaries where emp_no=? ");
 statement3.setInt(1, empNo);
 ResultSet resultSet2=statement3.executeQuery();
     //   ArrayList<Employee> employeeList=new ArrayList<Employee>();
        //use resultset
        Employee employee = new Employee();

        while (resultSet.next()) {
            employee.setEmpNo(resultSet.getInt(1));
            employee.setBirthDate(resultSet.getDate(2));
            employee.setFirstName(resultSet.getString(3));
            employee.setLastName(resultSet.getString(4));
            employee.setGender(resultSet.getString(5));
            employee.setHireDate(resultSet.getDate(6));
            
          //  employeeList.add(employee);
        }
        while (resultSet2.next()){
        	employee.setSalary(resultSet2.getInt(2));
        }
        return employee;
	}
	public void addEmployee(int employeeId, String firstName, String lastName, String gender, Date birthDate,
			Date hireDate,int salary) throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement statement = connection.prepareStatement("insert into employees values( ?,?,?,?,?,?)");
        statement.setInt(1,employeeId);
        statement.setDate(2,birthDate);
        statement.setString(3, firstName);
        statement.setString(4, lastName);
        statement.setString(5, gender);
        statement.setDate(6, hireDate);
        statement.executeUpdate();
        PreparedStatement statement2=connection.prepareStatement("insert into salaries values( ?,?,?,?)");
        statement2.setInt(1,employeeId);
        statement2.setInt(2,salary);
        statement2.setDate(3, hireDate);
        statement2.setDate(4,date);
        statement2.executeUpdate();

	}
	public void updateEmployee(int employeeId, String firstName, String lastName, String gender, Date birthDate,
			Date hireDate) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement statement = connection.prepareStatement("update employees SET birth_date=?,first_name=?,last_name=?,gender=?,hire_date=? where emp_no=?");
        statement.setDate(1,birthDate);
        statement.setString(2, firstName);
        statement.setString(3, lastName);
        statement.setString(4, gender);
        statement.setDate(5, hireDate);
        statement.setInt(6,employeeId);
        statement.executeUpdate();

        
		
	}

	public EmployeeOperationsImpl() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSalary(int empNo) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement statement = connection.prepareStatement("select avg(salary) from salaries where emp_no="+empNo);
        ResultSet resultSet = statement.executeQuery();
        int salary=0;
        while(resultSet.next()){
        salary=resultSet.getInt(1);
        }
    	return salary;
	}

	private Connection createConnection() throws ClassNotFoundException, SQLException {
        //register driver
       Class.forName("com.mysql.jdbc.Driver");

        //establish connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "root1234");

        return connection;
    }
	

	
}