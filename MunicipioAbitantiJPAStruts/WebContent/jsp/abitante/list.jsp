<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

		<%@ include file="/header.jsp"%>

		<div class="page-header">
	<table border="2" class="table table-striped">
		<thead>
			<th>NOME</th>
			<th>COGNOME</th>
			<th>AZIONI</th>
		</thead>
		<c:forEach var="abitanteItem" items="${AbitantiList }">
			<tbody>
				<tr>
					<td>${abitanteItem.nome }</td>
					<td>${abitanteItem.cognome }</td>
					<td><a href="${pageContext.request.contextPath }/abitante.do?idAbitante=${abitanteItem.id}&codop=show" class="btn btn-info">visualizza</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>