package br.org.fepb.seginus.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Criado por Thiago em 19/09/2016
 */
@Entity
@Table(name = "tb_usuario_sistema", uniqueConstraints={@UniqueConstraint(columnNames={"fk_usuario", "fk_sistema"})})
@EqualsAndHashCode(callSuper = false)
@Data
public class UsuarioSistema extends GenericModel {

    @ManyToOne
    @JoinColumn(name="fk_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="fk_sistema")
    private Sistema sistema;
    @Column(name="data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    public UsuarioSistema() {
    	//vazio
    }
    
    public UsuarioSistema(Usuario usuario, Sistema sistema, Date dataCadastro) {
        this.usuario = usuario;
        this.sistema = sistema;
        this.dataCadastro = dataCadastro;
    }

	@Override
	public String toString() {
		return "UsuarioSistema [usuario=" + usuario + ", sistema=" + sistema + ", dataCadastro=" + dataCadastro + "]";
	}
    
    
    
}
