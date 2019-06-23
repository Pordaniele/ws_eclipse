<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina dei risultati</title>
</head>
<body>
	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina dei Risultati</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>denominazione</th>
					<th>esperienza minima</th>
					<th>cifra minima</th>
					
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listTavoli }" var="tavoloItem">
					<tr>
						<td>${tavoloItem.id }</td>
						<td>${tavoloItem.denominazione }</td>
						<td>${tavoloItem.esperienzaMin }</td>
						<td>${tavoloItem.cifraMin }</td>
					<c:if test='${!userInfo.isInGame()}'>
						<td><a
							href="game?idTavolo=${tavoloItem.id }"
							class="btn btn-info">gioca </a>	</td></c:if>
				</c:forEach>


			</tbody>

		</table>
		<div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <a href="create" class="btn btn-primary btn-md">Inserisci Nuovo Elemento</a>
	      </div>
	    </div>

	</div>


</body>
</html>