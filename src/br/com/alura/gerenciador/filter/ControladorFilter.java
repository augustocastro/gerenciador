package br.com.alura.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

@WebFilter("/entrada")
public class ControladorFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String retornoAcao;
		
		try {
			String paramAcao = request.getParameter("acao");
			String className = new StringBuilder("br.com.alura.gerenciador.acao.").append(paramAcao).toString();
			Class<?> classe = Class.forName(className);
			Acao acao = (Acao) classe.newInstance();
			retornoAcao = acao.executa(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}

		String[] tipoRespontaAndUrl = retornoAcao.split(":");
		if (tipoRespontaAndUrl[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/" + tipoRespontaAndUrl[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoRespontaAndUrl[1]);
		}
		
	}

}
