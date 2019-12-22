package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.helper.DateHelper;
import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import br.com.alura.gerenciador.security.RequireAuthorization;

@RequireAuthorization
public class NovaEmpresa implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		String nomeEmpresa = request.getParameter("nome");
		Date dataAbertura = DateHelper.stringToDate(request.getParameter("data"));

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		new Banco().adiciona(empresa);

		request.setAttribute("empresa", empresa.getNome());
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
