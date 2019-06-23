<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricarica</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Ricarica il tuo credito</h3>
			
			
			
		</div>




		<form:form class="form-horizontal" action="buyCredit" method="post"
			commandName="playCommand">

			<div class="form-group">
				<label class="control-label col-sm-2" for="creditoAccumulato">Credito:</label>
				<div class="col-sm-4">
					<form:input type="number" class="form-control"
						path="creditoAccumulato" id="creditoAccumulato" />
					<form:errors path="creditoAccumulato" cssStyle="color:red;" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Effettua
						Inserimento</button>
				</div>
			</div>
		</form:form>

	</div>
	

</body>
</html>