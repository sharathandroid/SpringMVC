<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<!-- <style>
span.error {
   color: red;
} -->
</style>
<meta charset="ISO-8859-1">
<title>Employee</title>
<script type="text/javascript"> 
/* function Validate()
{
	var name = document.getElementById('FirstName').value;
	var salary = document.getElementById('Salary').value;

	var valid = true;
	                if(name.length<8 )
	                    {
	                        alert("Name should be 8 characters!");
	                        valid = false;
	                    }
	                if(salary<1000 )
                    {
                        alert("Salary Should be greater than 1000!");
                        valid = false;
                    }
return valid; 
} */
  </script>

</head>

<body>
	<form action="/employee" method="get">
		EmployeeId<input type="text" name="employeeId"><br> <input
			type="submit" value="Submit">
	</form>
	<form:form  class="form-horizontal"
		action="/employee" method="Post" commandName="employee"
		>
		<fieldset>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">EmployeeId</label>
				<div class="col-md-4">
					<form:input path="empNo" placeholder="EmployeeId"
						class="form-control input-md" required="" /> <span
						class="help-block"> </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">First
					Name</label>
				<div class="col-md-4">
					<form:input id="FirstName" path="firstName"  cssClass="error"
						placeholder="Employee First Name" class="form-control input-md"
						required="" /> <td> <form:errors path="firstName" cssStyle="color: red;"/> </td><span class="help-block">
					</span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Last
					Name</label>
				<div class="col-md-4">
					<form:input path="lastName" placeholder="Employee Last Name"
						class="form-control input-md" required="" type="text"/> <span
						class="help-block"> </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Gender</label>
				<div class="col-md-4">
					<form:input path="gender" placeholder="Gender"
						class="form-control input-md" required="" type="text"/> <span
						class="help-block"> </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">BirthDate
				<div class="col-md-4">
					<form:input path="birthDate" placeholder="BirthDate(yyyy-MM-dd)"
						class="form-control input-md" required="" type="text"/> <span
						class="help-block"><td> <form:errors path="*" cssStyle="color: red;"/> </td></span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">HireDate</label>
				<div class="col-md-4">
					<form:input path="hireDate" placeholder="HireDate"
						class="form-control input-md" required="" type="text"/> <span
						class="help-block"> </span>
				</div>
			</div>
<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Salary</label>
				<div class="col-md-4">
					<form:input id="Salary" path="salary" placeholder="Salary"
						class="form-control input-md" required="" type="text"/> <span
						class="help-block"> </span>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"> </label>
				<div class="col-md-4">
					<input type="submit" value="Add" name="Add" ></button> 
					<input	type="submit" value="Update" name="Update">
				</div>
			</div>

		</fieldset>
	</form:form>
</body>
</html>