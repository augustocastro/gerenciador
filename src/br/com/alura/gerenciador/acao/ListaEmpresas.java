package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import br.com.alura.gerenciador.security.RequireAuthorization;

@RequireAuthorization
public class ListaEmpresas implements Acao {

	@Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		List<Empresa> empresas = new Banco().getEmpresas();
        request.setAttribute("empresas", empresas);
        return "forward:listaEmpresas.jsp";
    }
}
