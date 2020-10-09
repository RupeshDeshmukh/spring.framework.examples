<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="cache-control" content="no-cache" />
<title>${application.name}</title>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
</head>
<body>
	<center>
		<div align="center"
			style="background-color: #004F7C; color: white; width: 55%;">
			<br />
			<h3>Add Employee</h3>
			<form:form method="POST" modelAttribute="employee"
				commandName="employee" action="/example14-web/employee/add">
				<table>
					<tr>
						<td><label for="firstName"><s:message
									code="add.employee.firstname" /></label></td>
						<td><form:input id="firstName" path="firstName" /></td>
						<td><form:errors path="firstName" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label for="lastName"><s:message
									code="add.employee.lastname" /></label></td>
						<td><form:input id="lastName" path="lastName" /></td>
						<td><form:errors path="lastName" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label for="salaryCode"><s:message
									code="add.employee.salarycode" /></label></td>
						<td><form:input id="salaryCode" path="salaryCode" /></td>
						<td><form:errors path="salaryCode" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label for="emailAddress"><s:message
									code="add.employee.contactdetails.emailaddress" /></label></td>
						<td><form:input id="emailAddress"
								path="contactDetails.emailAddress" /></td>
						<td><form:errors path="contactDetails.emailAddress"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td><label for="mobileNumber"><s:message
									code="add.employee.contactdetails.mobilenumber" /></label></td>
						<td><form:input id="mobileNumber"
								path="contactDetails.mobileNumber" /></td>
						<td><form:errors path="contactDetails.mobileNumber"
								cssClass="error" /></td>
					</tr>
				</table>
				<br />
				<input name="submit" type="submit" value="Add Employee" />
				<input name="resetForm" type="reset" value="Reset" />
				<input name="cancel" type="button" value="Cancel"
					onclick="location.href='/example14-web/employee'" />
				<br />
			</form:form>
			<br />
		</div>
	</center>
</body>
</html>