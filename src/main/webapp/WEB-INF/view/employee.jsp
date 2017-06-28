<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<form:form class="form-horizontal" action="/employee" method="Post"
		commandName="employee">
		<fieldset>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">EmployeeId</label>
				<div class="col-md-4">
					<form:input path="employeeId" placeholder="EmployeeId"
						class="form-control input-md" required="" />
					<span class="help-block"> </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">First
					Name</label>
				<div class="col-md-4">
					<form:input id="FirstName" path="FirstName" cssClass="error"
						placeholder="Employee First Name" class="form-control input-md"
						required="" />
					<td><form:errors path="FirstName" cssStyle="color: red;" /></td> <span
						class="help-block"> </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Last
					Name</label>
				<div class="col-md-4">
					<form:input path="LastName" placeholder="Employee Last Name"
						class="form-control input-md" required="" type="text" />
					<span class="help-block"> </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Gender</label>
				<div class="col-md-4">
					<form:input path="gender" placeholder="Gender"
						class="form-control input-md" required="" type="text" />
					<span class="help-block"> </span>
				</div>
			</div>
			

				<div class="form-group">
					<form:label path="addressList[0].state">Street Name</form:label>
					<form:input path="addressList[0].state" cssClass="form-control" />
				</div>
				<%--  <div class="form-group">
    <form:label path="city">City</form:label>
    <form:input path="city" cssClass="form-control"/>
  <div>
  <div class="form-group">
    <form:label path="state">State</form:label>
    <form:input path="state" cssClass="form-control"/>
  </div>
  <div class="form-group">
    <form:label path="zipcode">State</form:label>
    <form:input path="zipcode" cssClass="form-control"/>
  </div> --%>
			<%-- <div class="form-group">
<c:forEach items="${employee.addressList}" varStatus="vs">
        <div class="field">
        <div class="label required"><form:form
            path="addressList[${vs.index}].street"  cssErrorClass="invalid">Street</form:form></div>
        <div class="input"><form:input path="addressList[${vs.index}].street"
            cssErrorClass="invalid " /><form:label
            path="addressList[${vs.index}].street" cssErrorClass="icon invalid" /><form:errors
            path="addressList[${vs.index}].street" cssClass="inline_invalid" /></div>
        </div>
        <form:form path="collegeList[${vs.index}].street" />
        <hr />
 	
	</div>	 --%>

			<c:forEach items="${employee.getAddressList()}" var="address">
				<tr>
					<td>Address</td>
					<td>${address.getStreet()}<br> <%-- ${address.getLine2()}<br>
							${address.getCity()},${address.getState()}-${address.getZip()} --%>
					</td>
				</tr>
			</c:forEach>
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Salary</label>
				<div class="col-md-4">
					<form:input id="Salary" path="Salary.salary" placeholder="Salary"
						class="form-control input-md" required="" type="text" />
					<span class="help-block"> </span>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"> </label>
				<div class="col-md-4">
					<input type="submit" value="Add" name="Add">
					</button>
					<input type="submit" value="Update" name="Update">
				</div>
			</div>
		</fieldset>
	</form:form>
</body>
</html>