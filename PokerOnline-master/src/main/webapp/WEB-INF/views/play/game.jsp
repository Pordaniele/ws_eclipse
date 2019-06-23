<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Poker Online</title>
</head>
<body>

	<div class="container">
		<%@ include file="../header.jsp"%>

<h3>You’re playing now </h3>
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


<form:form class="form-horizontal" action="playButton" method="post"
			commandName="playCommand">

			<div class="form-group">
				<label class="control-label col-sm-2" for="creditoAccumulato">Credito:</label>
				<div class="col-sm-4">
					<form:input type="text" readonly="true" class="form-control"
						path="creditoAccumulato" id="creditoAccumulato" />
					
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Gioca</button>
		</div>
			</div>
		</form:form>
			
  <a href="exit" class="btn btn-primary btn-md">Lascia Partita</a>


</body>
</html>