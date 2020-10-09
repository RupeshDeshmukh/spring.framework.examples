<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="cache-control" content="no-cache" />
<title>${application.name}</title>
</head>
<body>
	<center>
		<div align="center"
			style="background-color: #004F7C; color: white; width: 55%;">
			<br />
			<h3>Employee Search</h3>
			<form:form method="POST" modelAttribute="employeeSearch"
				commandName="employeeSearch" action="/example14-web/employee/search">
				<table>
					<tr>
						<td><label for="searchByFirstName"><s:message
									code="search.criteria.employee.firstname" /></label></td>
						<td><form:input id="searchByFirstName" path="firstName" /></td>
						<td>&nbsp;</td>
						<td><label for="searchByLastName"><s:message
									code="search.criteria.employee.lastname" /></label></td>
						<td><form:input id="searchByLastName" path="lastName" /></td>
					</tr>
					<tr>
						<td><label for="searchBySalaryCode"><s:message
									code="search.criteria.employee.salarycode" /></label></td>
						<td><form:input id="searchBySalaryCode" path="salaryCode" /></td>
						<td>&nbsp;</td>
						<td><label for="searchByEmailAddress"><s:message
									code="search.criteria.employee.contactdetails.emailaddress" /></label></td>
						<td><form:input id="searchByEmailAddress" path="emailAddress" /></td>
					</tr>
					<tr>
						<td><label for="searchByMobileNumber"><s:message
									code="search.criteria.employee.contactdetails.mobilenumber" /></label></td>
						<td><form:input id="searchByMobileNumber" path="mobileNumber" /></td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
				<br />
				<input name="submit" type="submit" value="Search Employee" />
				<input name="resetForm" type="reset" value="Reset" />
				<input name="addEmployee" type="button" value="Add Employee" onclick="location.href='/example14-web/employee/addform'" />
			</form:form>
			<br />
		</div>
		<br />
		<div align="center"
			style="background-color: #004F7C; color: white; width: 55%;">
			<br />
			<h3>Employee Search Result</h3>
			<table border="1" bordercolor="white">
				<tr>
					<th><s:message code="search.result.employee.firstname" /></th>
					<th><s:message code="search.result.employee.lastname" /></th>
					<th><s:message code="search.result.employee.salarycode" /></th>
					<th><s:message
							code="search.result.employee.contactdetails.emailaddress" /></th>
					<th><s:message
							code="search.result.employee.contactdetails.mobilenumber" /></th>
				</tr>
				<c:forEach var="employee" items="${employees}">
					<tr>
						<td>${employee.firstName}</td>
						<td>${employee.lastName}</td>
						<td>${employee.salaryCode}</td>
						<td>${employee.contactDetails.emailAddress}</td>
						<td>${employee.contactDetails.mobileNumber}</td>
					</tr>
				</c:forEach>
			</table>
			<br />
		</div>
	</center>
</body>
</html>