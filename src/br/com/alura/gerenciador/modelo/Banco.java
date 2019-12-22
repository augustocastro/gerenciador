package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import br.com.alura.gerenciador.helper.DateHelper;

public class Banco {
	
	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		empresa1.setNome("Alura");
		empresa1.setDataAbertura(DateHelper.stringToDate("16/06/1998"));
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		empresa2.setDataAbertura(DateHelper.stringToDate("17/10/2001"));
		Banco.listaEmpresas.addAll(Arrays.asList(empresa1, empresa2));
		
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("augusto");
		usuario1.setSenha("123");
		
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("teste");
		usuario2.setSenha("123");
		Banco.listaUsuarios.addAll(Arrays.asList(usuario1, usuario2));
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.listaEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.listaEmpresas;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = listaEmpresas.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : listaEmpresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
	public Usuario existeUsuario(String login, String senha) {
	    for(Usuario usuario : listaUsuarios) {
	        if(usuario.ehIgual(login, senha)) {
	            return usuario;
	        }
	    }
	    return null;
	}

}
