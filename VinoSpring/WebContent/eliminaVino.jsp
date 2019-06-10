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
	<%
		Vino vinoInPagina = (Vino) request.getAttribute("vinoDaEliminare");
	%>

	<div class="container">

		<%@ include file="header.jsp"%>

		<div class="page-header">
			<h3>Elimini questo vino???</h3>
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
				<dt class="col-sm-3 text-right">Cantina</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getCantina()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Localita</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getLocalita()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Annata</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getAnnata()%></dd>
			</dl>
		</div>
		<a href="EliminaServlet?idVino=<%=vinoInPagina.getId()%>"
			class="btn btn-info">Eliminalo</a> <a href="search.jsp"
			class="btn btn-info">Non eliminare</a>
	</div>
</body>
</html>