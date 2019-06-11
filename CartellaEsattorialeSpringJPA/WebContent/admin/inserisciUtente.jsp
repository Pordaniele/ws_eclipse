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
		<form class="form-horizontal" action="InserisciUtenteServlet"
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
			</div>
			<c:forEach items="${listaRuoli }" var="item">
				<input type="checkbox" name="ruoloId" value="${item.id }">${item.descrizione }<br>
			</c:forEach>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Inserisci
						nuovo Utente</button>
				</div>
			</div>
		</form>

	</div>

	<!-- /.container -->
</body>
</html>