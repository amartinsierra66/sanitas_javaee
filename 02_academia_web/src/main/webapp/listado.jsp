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
	<form action="alumnos" method="get">
		Curso: <input type="text" name="curso"><br>
		<input type="submit" value="Ver alumnos"> 
	
	</form>
	<br>
	<br>
	<table border="1">
		<tr><th>Nombre</th><th>Curso</th><th>Nota</th></tr>
		<c:forEach var="al" items="${requestScope.alumnos}">
			<tr>
				<td>${al.nombre}</td>
				<td>${al.curso}</td>
				<td>${al.nota}</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<a href="toInicio">Volver</a>
</body>
</html>