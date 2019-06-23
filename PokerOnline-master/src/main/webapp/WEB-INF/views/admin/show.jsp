<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Utente</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio Tavolo</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9">${adminCommand.id }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9">${adminCommand.nome}</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9">${adminCommand.cognome }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Username</dt>
				<dd class="col-sm-9">${adminCommand.username }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Stato</dt>
				<dd class="col-sm-9">${adminCommand.statoUtenza.descrizione }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Data registrazione</dt>
				<dd class="col-sm-9">${adminCommand.dataRegistrazione }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Esperienza accumulata</dt>
				<dd class="col-sm-9">${adminCommand.esperienzaAccumulata }</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Credito accumulato</dt>
				<dd class="col-sm-9">${adminCommand.creditoAccumulato }</dd>
			</dl>
		</div>
		<div class="form-group">        
	      <div class="col-sm-offset-2 col-sm-10">
	        <a href="list" class="btn btn-primary btn-md">Torna alla lista</a>
	      </div>
	    </div>

	</div>

</body>
</html>