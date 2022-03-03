<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1><a href="toDatos">Nuevo alumno</a></h1>
		<h1><a href="media">Nota media</a></h1>
		<h1><a href="toLstado">Alumnos de curso</a></h1>
		<br>
		<c:if test="${! empty requestScope.mensaje}">
			${requestScope.mensaje}
		
		</c:if>
	</center>
</body>
</html>