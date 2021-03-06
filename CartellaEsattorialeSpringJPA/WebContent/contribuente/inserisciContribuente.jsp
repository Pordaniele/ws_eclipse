<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">

	<h3>Inserisci Contribuente</h3>
			
		</div>
		<div class="alert alert-danger alert-dismissible fade show ${messaggioDiErrore != null?'':'d-none' }" role="alert">
 		<c:forEach items="${messaggioDiErrore }" var="item"> 
 			<p>${item } </p>
			</c:forEach> 
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
		</div>
		<form class="form-horizontal" action="InserisciContribuenteServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="codiceFiscaleInputId">Codice Fiscale:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceFiscaleInputId"
						name="codiceFiscaleInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="indirizzoInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="indirizzoInputId"
						name="indirizzoInput">
				</div>
			</div>
		
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Inserisci nuovo abitante</button>
				</div>
			</div>
		</form>

	</div>
	
	<!-- /.container -->
</body>
</html>