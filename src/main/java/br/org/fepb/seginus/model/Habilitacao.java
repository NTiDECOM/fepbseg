package br.org.fepb.seginus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Criado por Thiago em 19/09/2016
 */
@Entity
@Table(name = "tb_habilitacao"/*, uniqueConstraints={@UniqueConstraint(columnNames={"fk_perfil", "fk_usuario_sistema"})}*/)
@EqualsAndHashCode(callSuper = false)
@Data
public class Habilitacao extends GenericModel {

    @ManyToOne
    @JoinColumn(name="fk_perfil")
    private Perfil perfil;
    @ManyToOne
    @JoinColumn(name="fk_usuario_sistema")
    private UsuarioSistema usuarioSistema;
    @Column
    private boolean excluido;
    
    public Habilitacao(){
    	//vazio
    }
    
    public Habilitacao(Perfil perfil, UsuarioSistema usuarioSistema) {
        this.perfil = perfil;
        this.usuarioSistema = usuarioSistema;
    }

	@Override
	public String toString() {
		return "Habilitacao [perfil=" + perfil + ", usuarioSistema=" + usuarioSistema + ", excluido=" + excluido + "]";
	}
    
    
}
