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
<body>

	<%
		Vino vinoInPagina = (Vino) request.getAttribute("vinoSingoloAttributeName");
	%>

	<div class="container">

		<%@ include file="header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getNome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Annata</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getAnnata()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cantina</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getCantina()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Uva</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getUva()%></dd>
			</dl>
		</div>

	</div>
	<a href="home.jsp" class="btn btn-info">Torna alla pagina
		iniziale</a>
		 </div><!-- /.container -->
</body>
</html>