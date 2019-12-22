package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import br.com.alura.gerenciador.security.RequireAuthorization;

@RequireAuthorization
public class MostraEmpresa implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Empresa empresa = new Banco().buscaEmpresaPelaId(id);
		request.setAttribute("empresa", empresa);
		return "forward:formAlteraEmpresa.jsp";
	}

}
