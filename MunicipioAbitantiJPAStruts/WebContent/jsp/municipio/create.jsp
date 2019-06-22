<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
<div class="container">

		<%@ include file="/header.jsp"%>

		<div class="page-header">

<form class="form-horizontal" action="${pageContext.request.contextPath }/municipio.do" method="post">

	DESCRIZIONE: <input type="text" name="descrizione" value="${MunicipioForm.descrizione }"><br>
	CODICE: <input type="text" name="codice" value="${MunicipioForm.codice }"><br>
	UBICAZIONE: <input type="text" name="ubicazione" value="${MunicipioForm.ubicazione }"><br>
	<input type="hidden" name="codop" value="save"> 
	<input type="submit" value="INSERISCI">
</form>
</body>
</html>