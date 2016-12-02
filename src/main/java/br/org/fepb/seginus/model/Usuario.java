package br.org.fepb.seginus.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Criado por Thiago em 19/09/2016
 */
@Entity
@Table(name = "tb_usuario")
@EqualsAndHashCode(callSuper = false)
@Data
public class Usuario extends GenericModel {

    @Column(unique = true, length = 11)
    private String cpf;
    @Column
    private String nome;
    //TODO: Criptografar MD5
    @Column
    private String senha;
    @Column(unique = true)
    private String email;
    @Column(name="data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Column
    private boolean ativo;
    
    public Usuario() {
        //vazio
    }
    
    public Usuario(String cpf, String nome, 
            String senha, String email, 
            Date dataCadastro) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.dataCadastro = dataCadastro;

    }

	@Override
	public String toString() {
		return "Usuario [cpf=" + cpf + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", dataCadastro="
				+ dataCadastro + ", ativo=" + ativo + "]";
	}
    
}
