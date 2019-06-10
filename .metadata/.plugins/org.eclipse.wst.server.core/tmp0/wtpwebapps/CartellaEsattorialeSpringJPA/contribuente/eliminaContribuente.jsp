<%@page import="it.prova.cartellaesattorialespringjpa.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../header.jsp" %>
      
    <div class="page-header">

	
			<h3>Pagina di eliminazione contribuente</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${contribuenteDaEliminare.id }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${contribuenteDaEliminare.nome }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${contribuenteDaEliminare.cognome }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Indirizzo</dt>
				<dd class="col-sm-9">${contribuenteDaEliminare.indirizzo }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice Fiscale</dt>
				<dd class="col-sm-9">${contribuenteDaEliminare.codiceFiscale }</dd>
			</dl>	
		</div>

	
	<a href="EliminaContribuenteServlet?idContribuente=${contribuenteDaEliminare.id }" class="btn btn-info">Elimina</a>
	<a href="<%= request.getContextPath()%>/home.jsp" class="btn btn-info">Torna alla pagina
		iniziale</a>
</body>
</html>