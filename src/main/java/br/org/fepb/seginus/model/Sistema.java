package br.org.fepb.seginus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Criado por Thiago em 19/09/2016
 */
@Entity
@Table(name = "tb_sistema")
@EqualsAndHashCode(callSuper = false)
@Data
public class Sistema extends GenericModel {

    @Column
    private String sigla;
    @Column(unique=true)
    private String nome;
    @Column(unique=true)
    private String chave;
    @Column
    private String url;
    
    public Sistema() {
        //vazio
    }
    
    public Sistema(String sigla, String nome, 
            String chave, String url) {
        this.sigla = sigla;
        this.nome = nome;
        this.chave = chave;
        this.url = url;
    }

	@Override
	public String toString() {
		return "Sistema [sigla=" + sigla + ", nome=" + nome + ", chave=" + chave + ", url=" + url + "]";
	}
    
}
