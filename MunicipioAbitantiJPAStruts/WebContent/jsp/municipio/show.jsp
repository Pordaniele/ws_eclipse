<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizza Municipio</title>
</head>
<body>
<div class="container">

		<%@ include file="/header.jsp"%>

		<div class="page-header">
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${MunicipioForm.id }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9">${MunicipioForm.descrizione }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice</dt>
				<dd class="col-sm-9">${MunicipioForm.codice }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Ubicazione</dt>
				<dd class="col-sm-9">${MunicipioForm.ubicazione }</dd>
			</dl>
		</div>


<table border="2" class="table table-striped">
	<thead>
		<th>NOME</th>
		<th>COGNOME</th>
		<th>AZIONI</th>
	</thead>
	<c:forEach var="abitanteItem" items="${MunicipioForm.abitanti }">
		<tbody>
			<tr>
				<td>${abitanteItem.nome }</td>
				<td>${abitanteItem.cognome }</td>
				<td><a href="${pageContext.request.contextPath }/municipio.do?idMunicipio=${municipioItem.id}&codop=show">visualizza</a></td>
			</tr>
		</tbody>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath }/municipio.do?codop=create">Nuovo Municipio</a>
<form action="${pageContext.request.contextPath }/municipio.do">
	<input type="hidden" name="codop" value="delete" >
	<input type="hidden" name="idMunicipio" value="${MunicipioForm.id }">
	<input type="submit" value="RIMUOVI">
</form>
</body>
</html>