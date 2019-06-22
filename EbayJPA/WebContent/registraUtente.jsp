<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<%@ include file="../header.jsp"%>

		<div class="page-header">

			<h3>Inserisci Utente</h3>

		</div>
		<div
			class="alert alert-danger alert-dismissible fade show ${messaggioDiErrore != null?'':'d-none' }"
			role="alert">
			<c:forEach items="${messaggioDiErrore }" var="item">
				<p>${item }</p>
			</c:forEach>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<form name="myForm" class="form-horizontal"
			action="${pageContext.request.contextPath}/ExecuteRegistraUtenteServlet"
			method="post" onsubmit="return validateForm()">
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
				<label class="control-label col-sm-2" for="usernameInputId">Username:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="usernameInputId"
						name="usernameInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="passwordInputId">Password:</label>
				<div class="col-sm-4">
					<input class="form-control" type="password" id="passwordInputId"
						name="passwordInput">
				</div>
				<div class="form-group">
				<label class="control-label col-sm-2" for="passwordInputId2">Password:</label>
				<div class="col-sm-4">
					<input class="form-control" type="password" id="passwordInputId2"
						name="passwordInput2">
				</div>
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary btn-md">Inserisci
					nuovo Utente</button>
			</div>
	</div>
	</form>

	</div>

	<!-- /.container -->
</body>
<script>
function validateForm() {
	
  var nome = document.forms["myForm"]["nomeInput"].value;
  var cognome = document.forms["myForm"]["cognomeInput"].value;
  var username = document.forms["myForm"]["usernameInput"].value;
  var password = document.forms["myForm"]["passwordInput"].value;
 
  var confermaPassword =document.forms["myForm"]["passwordInput2"].value;
  
    if ((nome == "") || (nome == "undefined")) {
    	alert("Il campo Nome è obbligatorio.");
    	document.forms["myForm"]["nomeInput"].focus();
    	return false;
    	}
    if ((cognome == "") || (cognome == "undefined")) {
    	alert("Il campo cognome è obbligatorio.");
    	document.forms["myForm"]["cognomeInput"].focus();
    	return false;
    	}
    if ((username == "") || (username == "undefined")) {
    	alert("Il campo username è obbligatorio.");
    	document.forms["myForm"]["usernameInput"].focus();
    	return false;
    	}
    if ((password == "") || (password == "undefined")) {
    	alert("Il campo password è obbligatorio.");
    	document.forms["myForm"]["passwordInput"].focus();
    	return false;
    	} 
    if ((confermaPassword == "") || (confermaPassword == "undefined")) {
    	alert("Il campo conferma password è obbligatorio.");
    	document.forms["myForm"]["passwordInput2"].focus();
    	return false;
    	} 
    if (!(confermaPassword === password)) {
    	alert("le due password devono essere uguali");
    	document.forms["myForm"]["passwordInput2"].focus();
    	return false;
    	} 

 
}
</script>
