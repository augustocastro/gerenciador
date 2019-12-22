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
public class AlteraEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");
		Date dataAbertura = DateHelper.stringToDate(request.getParameter("data"));

		Empresa empresa =  new Banco().buscaEmpresaPelaId(id);
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
