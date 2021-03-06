<%@page import="java.util.List"%>
<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
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
      
    <div class="page-header">
			<h3>Pagina degli Abitanti</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Action</th>
				</tr>
			</thead>
			<%
				List<Abitante> listaAbitante = (List<Abitante>) request.getAttribute("listaAbitanteAttributeName");
				for (Abitante abitanteItem : listaAbitante) {
			%>
			<tr>
				<td><%=abitanteItem.getNome()%></td>
				<td><%=abitanteItem.getCognome()%></td>
				<td><a
					href="VisualizzaDettaglioAbitanteServlet?idAbitante=<%=abitanteItem.getId()%>"
					class="btn btn-info">Dettaglio</a> <a
					href="PreparaModificaAbitanteServlet?idAbitante=<%=abitanteItem.getId()%>"
					class="btn btn-info">Modifica</a> <a
					href="PreparaEliminaAbitanteServlet?idAbitante=<%=abitanteItem.getId()%>"
					class="btn btn-info">Elimina</a></td>
			</tr>

			<%
				}
			%>

		</table>
		 </div><!-- /.container -->
</body>
</html>