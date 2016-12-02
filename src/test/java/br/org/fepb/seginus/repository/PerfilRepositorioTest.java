/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.fepb.seginus.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.org.fepb.seginus.SeginusApplication;
import br.org.fepb.seginus.model.Perfil;

/**
 *
 * @author Thiago
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SeginusApplication.class)
public class PerfilRepositorioTest {
    
    @Autowired
    PerfilRepositorio perfilRepositorio;

    @Ignore
    @Test
    public void cadastrar() {
        Perfil perfil = new Perfil("PERFIL_TESTE"+new Random().nextInt(), "Responsável por manter evangelizados, matrículas e informações sobre as aulas");
        Perfil perfilbanco = perfilRepositorio.save(perfil);
        assertNotNull(perfilbanco);
    }
    
    @Ignore
    @Test
    public void editar() {
        String texto = "Manter evangelização no sistema";
        Perfil perfil = perfilRepositorio.findOne(1l);
        if(perfil!=null){
        perfil.setDetalhamento(texto);
        }
        Perfil perfilAtualizado = perfilRepositorio.save(perfil);
        assertNotNull(perfilAtualizado);
        assertNotNull(perfilAtualizado.getDetalhamento());
        assertEquals(perfilAtualizado.getDetalhamento(), texto);
    }
    
    @Test
    public void listarTudo() {
       Collection<Perfil> lista = (Collection<Perfil>) perfilRepositorio.findAll();
       assertTrue(!lista.isEmpty());
    }

    
}
