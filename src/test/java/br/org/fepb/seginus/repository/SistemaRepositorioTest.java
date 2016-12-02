package br.org.fepb.seginus.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.org.fepb.seginus.SeginusApplication;
import br.org.fepb.seginus.model.Sistema;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SeginusApplication.class)
public class SistemaRepositorioTest {

	@Autowired
	SistemaRepositorio SistemaRepositorio;

	@Ignore
	@Test
	public void cadastrar() {
		Sistema sistema = new Sistema("seginus", "SEGINUS - Sistema de Segurança", "klf78hsd023", "/seginus");
		Sistema SistemaBanco = SistemaRepositorio.save(sistema);
		assertNotNull(SistemaBanco);
	}

	@Ignore
	@Test
	public void editar() {
		String texto = "seginus";
		Sistema Sistema = SistemaRepositorio.findOne(1l);
		if (Sistema != null) {
			Sistema.setNome(texto);
			SistemaRepositorio.save(Sistema);
		}
		assertNotNull(Sistema);
		assertEquals(Sistema.getNome(), texto);
	}

	@Test
	public void listarTudo() {
		Collection<Sistema> lista = (Collection<Sistema>) SistemaRepositorio.findAll();
		assertTrue(!lista.isEmpty());
	}
}
