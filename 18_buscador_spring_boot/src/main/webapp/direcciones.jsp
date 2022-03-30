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
	<c:forEach var="pag" items="${requestScope.paginas}">
		<h2><a href="${pag.url}">${pag.nombre}</a></h2>
		${pag.descripcion}<br>
		<hr>
	</c:forEach>
	
	<br><br>
	<a href="volver">Volver</a>
</body>
</html>