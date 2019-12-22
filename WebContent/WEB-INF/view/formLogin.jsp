<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form action="${ linkEntradaServlet }" method="post">
		<div>
			<label>Login:</label> 
			<input type="text" name="login" />
		</div>

		<div>
			<label>Senha:</label> 
			<input type="password" name="senha" />
		</div>

		<div>
			<input type="hidden" name="acao" value="Login" /> 
			<input type="submit" />
		</div>
	</form>
</body>
</html>