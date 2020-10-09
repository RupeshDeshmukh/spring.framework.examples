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
			<h1>This is an index page which is not backed by a Controller.
				Hence it is used for serving static information.</h1>
		</div>
	</center>
</body>
</html>