package com.sharath.spring.mvc.repo;

import org.springframework.stereotype.Service;

import com.sharath.spring.mvc.Model.Employee;

import antlr.collections.List;
@Service
public interface IEmployeeDAO {
    java.util.List<Employee> getAllEmployees();
    Employee getEmployeeById(int pid);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int pid);
    boolean EmployeeExists(String username);
}