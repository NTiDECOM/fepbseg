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
import java.util.Date;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.org.fepb.seginus.SeginusApplication;
import br.org.fepb.seginus.model.Usuario;
import br.org.fepb.seginus.repository.UsuarioRepositorio;

/**
 *
 * @author Thiago
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SeginusApplication.class)
public class UsuarioRepositorioTest {
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Ignore
    @Test
    public void cadastrar(){
        Usuario usuario = new Usuario(String.valueOf(new Random().nextInt()*-1), "JOANA DE ANGELIS", "12345", "jangelis@nossolar.ter", new Date());
        Usuario usuarioBanco = usuarioRepositorio.save(usuario);
        assertNotNull(usuarioBanco);
    }
    
    @Ignore
    @Test
    public void editar(){
        String texto = "JOANNA DE ANGELIS";
        Usuario usuario = usuarioRepositorio.findOne(1l);
        if(usuario!=null){
            usuario.setNome(texto);
            usuarioRepositorio.save(usuario);
        }
        assertNotNull(usuario);
        assertEquals(usuario.getNome(), texto);
    }
    
    @Test
    public void listarTudo() {
        Collection<Usuario> lista = (Collection<Usuario>) usuarioRepositorio.findAll();
        assertTrue(!lista.isEmpty());
    }
    
}
