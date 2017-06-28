package com.sharath.spring.mvc.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.OpenSessionInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharath.spring.mvc.Model.Employee;
import com.sharath.spring.mvc.Model.Salary;

@Repository
public class EmployeeDAO implements IEmployeeDAO {
	private static final Logger logger=org.slf4j.LoggerFactory.getLogger(EmployeeDAO.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Employee getEmployeeById(int pid) {
	
	return sessionFactory.openSession().get(Employee.class, pid);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		return null;
	//	String hql = "FROM Employee as p ORDER BY p.pid";
	//	return (List<Employee>) hibernateTemplate.find(hql);
	}	
	@Override
	public void addEmployee(Employee employee) {
logger.debug("3");
Session session=sessionFactory.openSession();
Transaction transaction= session.beginTransaction();
Salary salary=new Salary();
System.out.println(employee.getSalary().getEmployee());
		employee.getSalary().setEmployee(employee);
		employee.getAddressList().get(0).setEmployee(employee);
		 session.save(employee);
		 transaction.commit();
	}
	@Override
	public void updateEmployee(Employee employee) {
		/*Employee p = getEmployeeById(employee.getEmpNo());
		p.setUsername(employee.getUsername());
		p.setPassword(employee.getPassword());
		p.setAge(employee.getAge());
		p.setGender(employee.getGender());
		p.setCity(employee.getCity());
		hibernateTemplate.update(p);*/
	}
	@Override
	public void deleteEmployee(int pid) {
	//	hibernateTemplate.delete(getEmployeeById(pid));
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean EmployeeExists(String username) {
		return false;
		/*String hql = "FROM Employee as p WHERE p.username = ?";
		List<Employee> Employees = (List<Employee>) hibernateTemplate.find(hql, username);*/
		//return Employees.size() > 0 ? true : false;
	}
}
