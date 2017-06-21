package com.sharath.spring.mvc.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sharath.spring.mvc.Model.Employee;
import com.sharath.spring.mvc.Service.EmployeeService;
import com.sharath.spring.mvc.validators.EmployeeValidator;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	private static final Logger logger=org.slf4j.LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private Employee emp;
	@Autowired
	private EmployeeValidator employeeValidator;
	@Autowired
	EmployeeService employeeService;
			
@RequestMapping(value="/{employeeId}", method=RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_HTML_VALUE})
public Employee getEmployeeDetails(@PathVariable(value="employeeId") Integer empId, Model model) throws SQLException{
Employee emp=	employeeService.getEmployeeInfo(empId);
	return emp;
}

}

