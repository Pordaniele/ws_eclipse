<%@page import="it.prova.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Persona local =(Persona) request.getAttribute("persona_attribute"); %>
il tuo nome � <%=local.getNome() %><br>
il tuo cognome � <%=local.getCognome() %><br><br>
<a href="registra.jsp">Torna alla home</a>
</body>
</html>