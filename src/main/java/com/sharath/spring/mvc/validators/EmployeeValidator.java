package com.sharath.spring.mvc.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.sharath.spring.mvc.Model.Employee;
@Component
public class EmployeeValidator implements Validator  {
	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "","Username is empty");
		if (employee.getFirstName().length()<7) {
			errors.rejectValue("firstName","", "Username length is less than 7");
		}
	}
} 