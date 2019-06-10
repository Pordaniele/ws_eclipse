<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
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
<%
		Municipio municipioInPagina = (Municipio) request.getAttribute("municipioSingoloAttributeName");
	%>

	
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=municipioInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9"><%=municipioInPagina.getDescrizione()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Ubicazione</dt>
				<dd class="col-sm-9"><%=municipioInPagina.getUbicazione()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice</dt>
				<dd class="col-sm-9"><%=municipioInPagina.getCodice()%></dd>
			</dl>
			
		</div>

	</div>
	<a href="<%= request.getContextPath()%>/home.jsp" class="btn btn-info">Torna alla pagina
		iniziale</a>
</body>
</html>