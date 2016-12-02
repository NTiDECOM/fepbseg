/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.fepb.seginus.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.org.fepb.seginus.SeginusApplication;
import br.org.fepb.seginus.model.Sistema;
import br.org.fepb.seginus.model.Usuario;
import br.org.fepb.seginus.model.UsuarioSistema;
import br.org.fepb.seginus.repository.SistemaRepositorio;
import br.org.fepb.seginus.repository.UsuarioRepositorio;
import br.org.fepb.seginus.repository.UsuarioSistemaRepositorio;

/**
 *
 * @author Thiago
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SeginusApplication.class)
public class UsuarioSistemaRepositorioTest {

    @Autowired
    UsuarioSistemaRepositorio usuarioSistemaRepositorio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    SistemaRepositorio sistemaRepositorio;
    
    @Ignore
    @Test
    public void cadastrarUsuarioSistema() {
        Usuario usu = usuarioRepositorio.findOne(1l);
        Sistema sis = sistemaRepositorio.findOne(1l);
        UsuarioSistema usuSis = new UsuarioSistema(usu, sis, new Date());
        UsuarioSistema usuSisBD = usuarioSistemaRepositorio.save(usuSis);
        assertNotNull(usuSisBD);
    }

    @Test
    public void findAllBySistemaChaveAndUsuarioCpf() {
        UsuarioSistema usuSis = usuarioSistemaRepositorio.findAllBySistemaChaveAndUsuarioCpf("klf78hsd023", "12583660");
        assertNotNull(usuSis);
    }

}
