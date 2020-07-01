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
<%@ include file="../header.jsp" %>
      
    <div class="page-header">


	
			<h3>Elimina Municipio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${municipioDaEliminare.id }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${municipioDaEliminare.descrizione }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice</dt>
				<dd class="col-sm-9">${municipioDaEliminare.codice }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Ubicazione</dt>
				<dd class="col-sm-9">${municipioDaEliminare.ubicazione }</dd>
			</dl>
			
		</div>

	<a href="${pageContext.request.contextPath}/municipio/ExecuteEliminaServlet?idMunicipio=${municipioDaEliminare.id }" class="btn btn-info">elimina</a>
	<a href="${pageContext.request.contextPath}/home.jsp" class="btn btn-info">Torna alla pagina
		iniziale</a>
</body>
</html>