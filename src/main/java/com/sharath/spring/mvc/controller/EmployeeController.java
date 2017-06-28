package com.sharath.spring.mvc.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sharath.spring.mvc.Model.Address;
import com.sharath.spring.mvc.Model.Employee;
import com.sharath.spring.mvc.Model.Salary;
import com.sharath.spring.mvc.Service.EmployeeService;
import com.sharath.spring.mvc.validators.EmployeeValidator;

@Controller
public class EmployeeController {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EmployeeController.class);
	/*
	 * @Autowired private Employee emp;
	 */
	@Autowired
	private EmployeeValidator employeeValidator;
	@Autowired
	EmployeeService employeeService;

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.addValidators(employeeValidator);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getEmployee(Model model) {
		logger.debug("getEmployee called");
		Employee employee= new Employee();
		Salary salary= new Salary();
		Address address= new Address();
		employee.setSalary(salary);
		salary.setEmployee(employee);
		address.setEmployee(employee);
		List<Address> addressList= new ArrayList<>();
		addressList.add(address);
		employee.setAddressList(addressList);
		logger.debug("Size is "+employee.getAddressList().size());
		model.addAttribute("employee", employee);
		return "employee";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String getEmployeeDetails(@RequestParam(value = "employeeId", required = false) Integer empId, Model model)
			throws SQLException {
		model.addAttribute("employee", employeeService.getEmployeeInfo(empId));

		return "employeedetails";
	}

	@RequestMapping(value = "/employee", params = "Add", method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
			Model model) throws SQLException {
		if (bindingResult.hasErrors()) {
			return "employee";
		}
		// employee.getAddressList().get(0).getState();
		logger.debug(employee.getSalary().getSalary().toString());
		employeeService.addEmpInfo(employee);
		model.addAttribute("employee", employeeService.getEmployeeInfo(employee.getEmployeeId()));
		return "employeedetails";
	}

	@RequestMapping(value = "/employee", params = "Update", method = RequestMethod.POST)
	public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
			Model model) throws SQLException {
		if (bindingResult.hasErrors()) {
			return "employee";
		}
		System.out.println("Update is calling");

		/*
		 * employeeService.updateEmpInfo( employee);
		 * model.addAttribute("employee",employeeService.getEmployeeInfo(
		 * employee.getEmployeeId()));
		 */
		return "employeedetails";
	}
}
