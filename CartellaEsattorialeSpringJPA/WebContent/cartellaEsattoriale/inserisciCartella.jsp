<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page
	import="it.prova.cartellaesattorialespringjpa.model.Contribuente"%>
<%@page import="java.util.List"%>
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

			<h3>Inserisci Cartella</h3>
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

		</div>

		<form class="form-horizontal" action="InserisciCartellaServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId"
						name="denominazioneInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="importoInputId"
						name="importoInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="ContribuenteInputId">Contribuente:</label>
				<select name="contribuenteInput">
					<option value="-1">----SELEZIONA CONTRIBUENTE----</option>

					<c:forEach items="${listaContribuentiAttribute }" var="item">
						<option value="${item.id }">${item.nome }${item.cognome }</option>

					</c:forEach>
				</select>
			</div>

			<br> <br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Inserisci</button>
				</div>
			</div>
		</form>
	</div>

	<!-- /.container -->
</body>
</html>