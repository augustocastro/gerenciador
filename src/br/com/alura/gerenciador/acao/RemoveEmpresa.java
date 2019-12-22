package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.security.RequireAuthorization;

@RequireAuthorization
public class RemoveEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		new Banco().removeEmpresa(id);
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
