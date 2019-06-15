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
		<%@ include file="../header.jsp"%>
		<div class="alert alert-danger ${messaggio==null?'d-none':''}"
			role="alert">${messaggio }</div>
		<div class="jumbotron">
			<div class="container">
				<h1 class="display-4">Area riservata: ${userInfo.nome }
					${userInfo.cognome } ${userInfo.creditoResiduo }</h1>
				<p>
					<a class="btn btn-primary btn-lg"
						href="<%=request.getContextPath() %>" role="button">Ricerca
						&raquo;</a>
				</p>
				
					<a class="btn btn-primary btn-lg"
						href="user/PrepareSearchAnnunciServlet?idUtente=${userInfo.id }"
						role="button">Gestione annunci &raquo;</a>
				</p>
				<p>
					<a class="btn btn-primary btn-lg"
						href="<%=request.getContextPath() + "/PrepareCronologiaAcquistiServlet"%>"
						role="button">Storico aquisti &raquo;</a>
				</p>
			</div>



		</div>
		<c:if test='${userInfo.isAdmin()}'>
			<div class="jumbotron">
				<div class="container">
					<h1 class="display-4">Gestione Utente</h1>
					<p>
						<a class="btn btn-primary btn-lg"
							href="<%=request.getContextPath() + "/admin/PrepareSearchUtentiServlet"%>"
							role="button">Vai alla Gestione &raquo;</a>
					</p>
				</div>
			</div>
		</c:if>
		<%@ include file="../footer.jsp"%>
	</div>
</body>
</html>