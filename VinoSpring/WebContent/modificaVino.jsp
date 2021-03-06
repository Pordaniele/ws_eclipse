<%@page import="it.prova.model.Vino"%>
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

		<%@ include file="header.jsp"%>
		<%
			if (request.getAttribute("messaggioDiErrore") != null) {
		%>
		<%=request.getAttribute("messaggioDiErrore")%>
		<%
			} else {
		%>Inserire dati da Modificare<br>
		<%
			}
		%>
		<%
			Vino vinoInPagina = (Vino) request.getAttribute("vinoDaModificare");
		%>
		<div class="page-header">
			<h3>Pagina di modifica</h3>
		</div>

		<form class="form-horizontal" action="ModificaVinoServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" value=<%=vinoInPagina.getNome()%>
						type="text" id="nomeInputId" name="nomeInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cantinaInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" value="<%=vinoInPagina.getCantina()%>"
						type="text" id="cantinaInputId" name="cantinaInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="localitaInputId">Localit�:</label>
				<div class="col-sm-4">
					<input class="form-control" value="<%=vinoInPagina.getLocalita()%>"
						type="text" id="localitaInputId" name="localitaInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="annataInputId">CF:</label>
				<div class="col-sm-4">
					<input class="form-control" value="<%=vinoInPagina.getAnnata()%>"
						type="text" id="annataInputId" name="annataInput">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="uvaInputId">Uva:</label>
				<div class="col-sm-4">
					<input class="form-control" value="<%=vinoInPagina.getUva()%>"
						type="text" id="uvaInputId" name="uvaInput">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Modifica</button>
				</div>
			</div>
			<input class="form-control" value="<%=vinoInPagina.getId()%>"
				type="hidden" id="idInputId" name="idVino">
		</form>

	</div>
	<!-- /.container -->
</body>
</html>