<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accedi</title>
</head>
<body>

	<div class="container">

		<%@ include file="../../header.jsp"%>

		<div class="page-header">
			<h1>Ricerca Categoria</h1>



			<form class="form-horizontal"
				action="${pageContext.request.contextPath}/admin/ExecuteSearchCategorieServlet"
				method="post">
				<div class="form-group">
					<label class="control-label col-sm-2" for="descrizioneInputId">Nome
						categoria:</label>
					<div class="col-sm-4">
						<input class="form-control" type="text" id="descrizioneInputId"
							name="descrizioneInput">
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary btn-md">Effettua
								Ricerca</button>
						</div>
					</div>
			</form>

		</div>
		</div><!-- /.container -->
</body>
</html>