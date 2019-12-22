<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Empresa</title>
</head>
<body>

	<form action="${ linkEntradaServlet }" method="post">
		<div>
			<label>Nome:</label>
			<input type="text" name="nome"  />
		</div>
		
		<div>
			<label>Data Abertura:</label>
			<input type="text" name="data"  />
		</div>

		<div>
			<input type="hidden" name="acao" value="NovaEmpresa" />
			<input type="submit" />
		</div>
	</form>
</body>
</html>