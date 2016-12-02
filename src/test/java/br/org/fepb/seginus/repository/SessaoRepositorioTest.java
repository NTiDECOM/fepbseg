/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.fepb.seginus.repository;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.org.fepb.seginus.SeginusApplication;
import br.org.fepb.seginus.model.Sessao;
import br.org.fepb.seginus.repository.SessaoRepositorio;

/**
 *
 * @author Thiago
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SeginusApplication.class)
public class SessaoRepositorioTest {
    
    @Autowired
    SessaoRepositorio sessaoRepositorio;

    @Test
    public void listarTudo() {
        Collection<Sessao> lista = (Collection<Sessao>) sessaoRepositorio.findAll();
        assertTrue(lista.isEmpty());
    }
    
}
