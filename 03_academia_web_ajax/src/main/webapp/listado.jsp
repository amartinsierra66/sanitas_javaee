<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function lanzarPeticion(){
		let url="alumnos";
		$.get(url,{"curso":$("#curso").val()},function(data,status){
			let tabla="<table border='1'><tr><th>Nombre</th><th>Curso</th><th>Nota</th></tr>";
			for(let al of data){
				tabla+="<tr><td>"+al.nombre+"</td><td>"+al.curso+"</td><td>"+al.nota+"</td></tr>";
			}
			tabla+"</table>";
			//volcamos la tabla en la estructura div donde se debe mostrar
			$("#tabla").html(tabla);
		});
	}
	/*function lanzarPeticion(){
		let url="alumnos?curso="+document.getElementById("curso").value;
		let xhr=new XMLHttpRequest(); //objeto encargado de lanzar las peticiones
		xhr.open("get",url,true); //configuración de la petición
		xhr.onreadystatechange=function(){
			//si la respuesta esta lista, se construye la tabla HTML
			//con el JSON
			if(xhr.readyState==4){
				let objJson=JSON.parse(xhr.responseText);
				let tabla="<table border='1'><tr><th>Nombre</th><th>Curso</th><th>Nota</th></tr>";
				for(let al of objJson){
					tabla+="<tr><td>"+al.nombre+"</td><td>"+al.curso+"</td><td>"+al.nota+"</td></tr>";
				}
				tabla+"</table>";
				//volcamos la tabla en la estructura div donde se debe mostrar
				document.getElementById("tabla").innerHTML=tabla;
			}
		};
		xhr.send(null);
	}
	*/

</script>
</head>
<body>
	
		Curso: <input type="text" name="curso" id="curso"><br>
		<input type="button" value="Ver alumnos" onclick="lanzarPeticion();"> 
	

	<br>
	<br>
	<div id="tabla">


	</div>
	<br><br>
	<a href="toInicio">Volver</a>
</body>
</html>