package br.com.drogaria.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTeste {

	@Test
	@Ignore
	public void salvar(){
		
		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRICAOA");
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("DESCRICAOB");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		fabricanteDAO.salvar(f1);
		fabricanteDAO.salvar(f2);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> fabricantes = fabricanteDAO.listar();
		
		for(Fabricante fabricante:fabricantes){
			System.out.println(fabricante.getDescricao());
		}
	}
	
	@Test
	public void buscarPorCodigo(){
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante f1 = fabricanteDAO.buscarPorCodigo(3L);
		
		System.out.println(f1.getDescricao());
		
	}
	
	
}
