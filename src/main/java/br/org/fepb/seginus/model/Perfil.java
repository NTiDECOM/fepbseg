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
@Table(name = "tb_perfil")
@EqualsAndHashCode(callSuper = false)
@Data
public class Perfil extends GenericModel {

    @Column(unique = true)
    private String descricao;
    @Column
    private String detalhamento;

    public Perfil() {
       //vazio
    }
    
    public Perfil(String descricao, String detalhamento) {
        this.descricao = descricao;
        this.detalhamento = detalhamento;
    }

	@Override
	public String toString() {
		return "Perfil [descricao=" + descricao + ", detalhamento=" + detalhamento + "]";
	}
    
}
