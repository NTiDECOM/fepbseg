/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.fepb.seginus.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.org.fepb.seginus.SeginusApplication;
import br.org.fepb.seginus.model.Habilitacao;
import br.org.fepb.seginus.model.Perfil;
import br.org.fepb.seginus.model.UsuarioSistema;

/**
 *
 * @author Thiago
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SeginusApplication.class)
public class HabilitacaoRepositorioTest {
    
    @Autowired
    HabilitacaoRepositorio habilitacaoRepositorio;
    @Autowired
    PerfilRepositorio perfilRepositorio;
    @Autowired
    UsuarioSistemaRepositorio usuarioSistemaRepositorio;
    
    @Test
    public void cadastrar(){
    	Perfil perfil = perfilRepositorio.findOne(1l);
    	UsuarioSistema usuarioSistema = usuarioSistemaRepositorio.findOne(1l);
    	Habilitacao habilitacao = new Habilitacao(perfil, usuarioSistema);
    	habilitacao = habilitacaoRepositorio.save(habilitacao);
    	assertNotNull(habilitacao);
    }
    
    @Test
    public void findAllByUsuarioSistemaId() {
        Collection<Habilitacao> lista = habilitacaoRepositorio.findAllByUsuarioSistemaId(1l);
        assertNotNull(lista);
        assertTrue(!lista.isEmpty());
    }
    
}
