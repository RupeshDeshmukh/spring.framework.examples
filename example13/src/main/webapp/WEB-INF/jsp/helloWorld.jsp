<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Example 13 - Spring MVC Hello World</title>
</head>
<body>
	<center>
		<h1>${message}</h1>
	</center>
	<h2 align="center">
		<strong>Time on the server is:</strong> ${serverTime}
	</h2>

	<table style="background-color: #004F7C; color: white;" border="1"
		bordercolor="white" align="center">
		<tr>
			<td>
				<h3>Below demonstrate usage of @RequestParam</h3> <strong>Select
					color of your choice: </strong><a
				href="/example13/color?userColorSelection=blue"
				style="color: white;">Blue</a> <a
				href="/example13/color?userColorSelection=green"
				style="color: white;">Green</a> <a
				href="/example13/color?userColorSelection=yellow"
				style="color: white;">Yellow</a>
			</td>
		</tr>
		<tr>
			<td>
				<h3>Below demonstrate usage of @PathVariable and
					@MatrixVariable</h3> <strong>View Document: </strong><br /> <a
				href="/example13/document/100;edition=2" style="color: white;">Spring
					in Action 2nd Edition</a> <a href="/example13/document/100;edition=3"
				style="color: white;">Spring in Action 3rd Edition</a>
			</td>
		</tr>
		<tr>
			<td>
				<h3>Below demonstrate usage of @RequestHeader</h3> <strong>View
					HTTP Header Details: </strong><br /> <a
				href="/example13/viewHttpHeaderDetails" style="color: white;">Header
					Details</a>
			</td>
		</tr>
		<tr>
			<td>
				<h3>Below demonstrate usage of @ResponseBody</h3> <strong>View
					JSON Format: </strong><br /> <a href="/example13/viewJsonFormat"
				style="color: white;">JSON Format</a>
			</td>
		</tr>
	</table>
</body>
</html>