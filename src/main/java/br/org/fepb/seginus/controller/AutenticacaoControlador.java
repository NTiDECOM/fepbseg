package br.org.fepb.seginus.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.fepb.seginus.model.Habilitacao;
import br.org.fepb.seginus.service.AutenticacaoServico;



/**
 * Criado por Thiago em 25/09/2016
 */
@RestController
@RequestMapping("/cas")
public class AutenticacaoControlador {

    @Autowired
    private AutenticacaoServico casServico;
    
    //exemplo: http://localhost:7004/cas/autenticar/chave=klf78hsd023&cpf=12583661
    @RequestMapping(method = RequestMethod.GET, value="/autenticar/chave={chave}&cpf={cpf}")
    @ResponseBody
    public ResponseEntity<Set<Habilitacao>> autenticar(@PathVariable("chave") String chave, @PathVariable("cpf") String cpf){
    	Set<Habilitacao> habilitacoes = casServico.autenticaUsuarioSistema(chave, cpf);
		if (habilitacoes!=null && !habilitacoes.isEmpty()) {
			//trocar por log4j
			System.out.println("O usuário com cpf '" + cpf + "' foi autorizado a acessar o(s) sistema(s): ");
			habilitacoes.stream().forEach(h -> System.out.println(
				h.getUsuarioSistema().getSistema().getSigla() + "(perfil: " + h.getPerfil().getDescricao() + ")")
			);
			//retorno
			return new ResponseEntity<Set<Habilitacao>>(HttpStatus.OK);
		} else {
			//trocar por log4j
			System.out.println("Foi negado acesso para o usuário com cpf '" + cpf + "'");
		}
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String info(){
    	return "seginus - 1.0 - AutenticacaoControlador";
    }
    
    
}
