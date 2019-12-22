package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Empresa> empresas = new Banco().getEmpresas();

		String contentType;
		String content;

		boolean acceptJson = request.getHeader("Accept").contains("application/json");
		if (acceptJson) {
			Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
			contentType = "application/json";
			content = gson.toJson(empresas);
		} else {
			XStream xstream = new XStream();
			xstream.registerConverter(new DateConverter("dd/MM/yyyy", new String[] { "HH:mm:ss" }));
			xstream.alias("empresa", Empresa.class);
			contentType = "application/json";
			content = xstream.toXML(empresas);
		}

		response.setContentType(contentType);
		response.getWriter().print(content);
	}

}
