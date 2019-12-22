<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Empresas</title>
</head>
	<body>
		<c:import url="logoutParcial.jsp" />
	
		<c:if test="${not empty empresa}">
			Empresa ${ empresa } cadastrada com sucesso!
		</c:if>
	
		<p><a href="/gerenciador/entrada?acao=NovaEmpresaForm">Nova Empresa</a></p>
	
		<table id="listEmpresas">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Data Abertura</th>
					<th>Editar</th>
					<th>Remover</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empresas}" var="empresa">
					<tr>
						<td>${ empresa.nome }</td>
						<td><fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/></td>
						<td><a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id }">Editar</a></td>
						<td><a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id }">Remover</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>



