<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Abitante local =(Abitante) request.getAttribute("abitanteDaInviareAPaginaDettalio"); %><br>
Descrizione!!!<br>

<%-- nome: <%=local.getNome() %><br> --%>
<%-- cognome: <%=local.getCognome() %><br> --%>
<%-- eta:<%=local.getEta() %><br> --%>
<%-- codice fiscale: <%=local.getCodiceFiscale() %><br> --%>
<%-- motto di vita: <%= local.getMottoDiVita() %><br> --%>
<table class="table">
  <thead>
    <tr>
      <th>Nome:</th>
      <th><%=local.getNome() %></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>cognome:</td>
      <td><%=local.getCognome() %></td>
    </tr>
    <tr>
      <td>eta:</td>
      <td><%=local.getEta() %></td>
    </tr>
    <tr>
      <td>codice fiscale:</td>
      <td> <%=local.getCodiceFiscale() %></td>
    </tr>
    <tr>
      <td>motto di vita:</td>
      <td> <%=local.getMottoDiVita() %></td>
    </tr>
  </tbody>
</table>

<a href="searchForm.jsp">Torna alla home page</a>
</body>
</html>