package br.org.fepb.seginus.controller;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.org.fepb.seginus.SeginusApplication;
import br.org.fepb.seginus.model.Habilitacao;

/**
*
* @author Thiago
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SeginusApplication.class)
public class AutenticacaoControladorTest {

	@Autowired
	private AutenticacaoControlador autenticacaoControlador;
	
	@Test
	public void testarAutenticacaoSucesso(){
			Set<Habilitacao> lista = (Set<Habilitacao>) autenticacaoControlador.autenticar("klf78hsd023", "12583660");
			assertNotNull(lista);
			assertTrue(lista.size() > 0);
			System.out.println(lista);
	}
	
	@Test
	public void testarAutenticaoNegada(){
			Set<Habilitacao> lista = (Set<Habilitacao>) autenticacaoControlador.autenticar("kgkgkkk", "12583660");
			assertNotNull(lista);
			assertTrue(lista.size() == 0);
	}
}
