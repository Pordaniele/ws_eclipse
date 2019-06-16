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

	
			<h3>Pagina di Dettaglio</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${dettaglioAnnuncio.id }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${dettaglioAnnuncio.testoAnnuncio }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Data Annuncio</dt>
				<dd class="col-sm-9">${dettaglioAnnuncio.dataAnnuncio }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Prezzo</dt>
				<dd class="col-sm-9">${dettaglioAnnuncio.prezzo }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Utente</dt>
				<dd class="col-sm-9">${dettaglioAnnuncio.utente.nome } ${dettaglioAnnuncio.utente.cognome }</dd>
			</dl>	
			<dl class="row">
				<dt class="col-sm-3 text-right">Categoria</dt>
				<dd class="col-sm-9"><c:forEach items="${dettaglioAnnuncio.categorie }" var="item">${item.descrizione }</c:forEach></dd>
			</dl>	
		</div>
					<a href="<%= request.getContextPath()%>/PrepareCompraServlet?idAnnuncio=${dettaglioAnnuncio.id }"
						class="btn btn-info">Acquista ${dettaglioAnnuncio.id }</a>
	
	<a href="${pageContext.request.contextPath}/home" class="btn btn-info">Torna alla pagina
		iniziale</a>
</body>
</html>