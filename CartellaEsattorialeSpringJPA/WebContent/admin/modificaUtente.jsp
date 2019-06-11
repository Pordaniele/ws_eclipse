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

			<h3>Modifica Utente</h3>
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


			<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/ModificaUtenteServlet"
				method="post">
				<div class="form-group">
					<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
					<div class="col-sm-4">
						<input class="form-control" value="${utenteDaModificare.nome}"
							type="text" id="nomeInputId" name="nomeInput">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
					<div class="col-sm-4">
						<input class="form-control" value="${utenteDaModificare.cognome }"
							type="text" id="cognomeInputId" name="cognomeInput">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="usernameInputId">Username:</label>
					<div class="col-sm-4">
						<input class="form-control"
							value="${utenteDaModificare.username }" type="text"
							id="usernameInputId" name="usernameInput">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="passwordInputId">Password:</label>
					<div class="col-sm-4">
						<input class="form-control"
							value="${utenteDaModificare.password }" type="password"
							id="passwordInputId" name="passwordInput">
					</div>
				</div>
				<input class="form-control" value="${utenteDaModificare.id }"
					type="hidden" id="idInputId" name="idInput">
				<c:forEach items="${listaRuoli }" var="item">
					<input type="checkbox" name="ruoloId" value="${item.id }"<c:forEach items="${utenteDaModificare.ruoli }" var="item2"><c:if test='${item.id==item2.id}'>checked</c:if></c:forEach>>${item.descrizione }<br>
				</c:forEach>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary btn-md">Inserisci</button>
					</div>
				</div>

			</form>
		</div>
	</div>
</body>
</html>