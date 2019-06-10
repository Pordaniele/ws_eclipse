<%@page import="java.util.List"%>
<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
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
			<h3>Pagina dei Municipio</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Descrizione</th>
					<th>Ubicazione</th>
					<th>Action</th>
				</tr>
			</thead>
			<%
				List<Municipio> listaMunicipio = (List<Municipio>) request.getAttribute("listaMunicipioAttributeName");
				for (Municipio municipioItem : listaMunicipio) {
			%>
			<tr>
				<td><%=municipioItem.getDescrizione()%></td>
				<td><%=municipioItem.getUbicazione()%></td>
				<td><a
					href="VisualizzaDettaglioMunicipioServlet?idMunicipio=<%=municipioItem.getId()%>"
					class="btn btn-info">Dettaglio</a> <a
					href="PreparaModificaMunicipioServlet?idMunicipio=<%=municipioItem.getId()%>"
					class="btn btn-info">Modifica</a> <a
					href="PreparaEliminaMunicipioServlet?idMunicipio=<%=municipioItem.getId()%>"
					class="btn btn-info">Elimina</a></td>
			</tr>

			<%
				}
			%>

		</table>
		 </div><!-- /.container -->
</body>
</html>