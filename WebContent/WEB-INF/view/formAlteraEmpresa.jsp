<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Empresa</title>
</head>
<body>

	<c:import url="logoutParcial.jsp" />

	<form action="${ linkEntradaServlet }" method="post">
		<div>
			<label>Id:</label> 
			<input disabled type="number" name="idShow" value="${empresa.id }"> 
			<input type="hidden" name="id" value="${ empresa.id }">
		</div>

		<div>
			<label>Nome:</label> 
			<input type="text" name="nome" value="${ empresa.nome }" />
		</div>

		<div>
			<label>Data Abertura:</label>
			<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" var="dataAbertura"/> 
			<input type="text" name="data" value="${ dataAbertura}" />
		</div>

		<input type="hidden" name="acao" value="AlteraEmpresa" /> <input
			type="submit" />
	</form>
</body>
</html>