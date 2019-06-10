<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> 

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Ricerca abitante</title>
</head>
<body>
<h1>Ricerca Abitante</h1>

<%if(request.getAttribute("messaggioDiErrore") != null){ %>
		<%=request.getAttribute("messaggioDiErrore") %>
	<% }else{ %>
		Inserire dati da ricercare<br>
	<%} %>
<!-- 	<form action="SearchServlet" method="post"> -->
<!-- 	NOME: -->
<!-- 	<input type="text" name="nomeInput" > -->
<!-- 	<br> -->
<!-- 	COGNOME: -->
<!-- 	<input type="text" name="cognomeInput" > -->
	
<!-- 	<input type="submit" value="CERCA"> -->
	
	</form>
	
  <form action="SearchServlet" method="post">
 <fieldset>
  <div class="row" >
   <div class="col-sm-5 col-lg-5">
  <div class="form-group">
   <label for="nome">Nome</label>
   <input type="text"  class="form-control" name="nomeInput" placeholder="Inserisci il nome...">
  </div>
  </div>
   </div>
    <div class="row">
   <div class="col-sm-5 col-lg-5">
  <div class="form-group">
   <label for="cognome">Cognome</label>
   <input type="text" class="form-control" name="cognomeInput" placeholder="Inserisci il cognome...">
  </div> 
  </div>
   </div>
   <button type="submit" value="CERCA" class="btn btn-default">Invia</button>
 </fieldset>
</form>

</body>
</html>