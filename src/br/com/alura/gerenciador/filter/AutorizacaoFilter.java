package br.com.alura.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.security.RequireAuthorization;

@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();

		try {
			boolean userNotAuthenticated = (session.getAttribute("usuario") == null);
			String acao = request.getParameter("acao");
			String className = new StringBuilder("br.com.alura.gerenciador.acao.").append(acao).toString();
			Class<?> classLoaded = Class.forName(className);
			
			if (classLoaded.isAnnotationPresent(RequireAuthorization.class) && userNotAuthenticated) {
				response.sendRedirect("entrada?acao=LoginForm");
				return;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		chain.doFilter(request, response);
	}

}
