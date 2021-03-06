<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="it.prova.cartellaesattorialespringjpa.model.dto.ContribuenteDTO"%>
<%@page
	import="it.prova.cartellaesattorialespringjpa.model.Contribuente"%>
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

			<h3>Inserisci Abitante${contribuenteDaModificare.nome }</h3>
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


			<form class="form-horizontal" action="ModificaContribuenteServlet"
				method="post">
				<div class="form-group">
					<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
					<div class="col-sm-4">
						<input class="form-control"
							value="${contribuenteDaModificare.nome}" type="text"
							id="nomeInputId" name="nomeInput">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
					<div class="col-sm-4">
						<input class="form-control"
							value="${contribuenteDaModificare.cognome }" type="text"
							id="cognomeInputId" name="cognomeInput">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo:</label>
					<div class="col-sm-4">
						<input class="form-control"
							value="${contribuenteDaModificare.indirizzo }" type="text"
							id="indirizzoInputId" name="indirizzoInput">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="codiceFiscaleInputId">Codice
						Fiscale:</label>
					<div class="col-sm-4">
						<input class="form-control"
							value="${contribuenteDaModificare.codiceFiscale }" type="text"
							id="codiceFiscaleInputId" name="codiceFiscaleInput">
					</div>
				</div>
				<input class="form-control" value="${contribuenteDaModificare.id }"
					type="hidden" id="idInputId" name="idInput">

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