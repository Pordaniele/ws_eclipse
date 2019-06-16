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
 <%@ include file="../header.jsp" %>
<div class="alert alert-danger ${messaggio==null?'d-none':''}" role="alert">
	  ${messaggio }
	</div>
	<div class="jumbotron">
      <div class="container">
        <h1 class="display-4">Gestione Utente</h1>
        <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/admin/PrepareSearchUtentiServlet" role="button">Vai alla Gestione &raquo;</a></p>
      </div>
      
    </div>
    <div class="jumbotron">
      <div class="container">
        <h1 class="display-4">Gestione Categorie</h1>
        <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/admin/PrepareSearchCategorieServlet" role="button">Vai alla Gestione &raquo;</a></p>
      </div>
</body>
</html>