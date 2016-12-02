package br.org.fepb.seginus.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fepb.seginus.model.Habilitacao;
import br.org.fepb.seginus.model.UsuarioSistema;
import br.org.fepb.seginus.repository.HabilitacaoRepositorio;
import br.org.fepb.seginus.repository.UsuarioSistemaRepositorio;

/**
 * Criado por Thiago em 25/09/2016
 */
@Service
public class AutenticacaoServico {

    @Autowired
    private UsuarioSistemaRepositorio usuarioSistemaRepositorio;
    
    @Autowired
    private HabilitacaoRepositorio habilitacaoRepositorio;
    
    public Set<Habilitacao> autenticaUsuarioSistema(String chave, String cpf){
    	Set<Habilitacao> habilitacoesPorUsuarioESistema = null;
        UsuarioSistema usuSis = usuarioSistemaRepositorio.findAllBySistemaChaveAndUsuarioCpf(chave, cpf);
        
        if(usuSis != null){
        	habilitacoesPorUsuarioESistema = habilitacaoRepositorio.findAllByUsuarioSistemaId(usuSis.getId());
        }
        return habilitacoesPorUsuarioESistema;
    }

}
