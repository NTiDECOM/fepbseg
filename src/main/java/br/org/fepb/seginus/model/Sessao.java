package br.org.fepb.seginus.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Criado por Thiago em 19/09/2016
 */
@Entity
@Table(name = "tb_sessao")
@EqualsAndHashCode(callSuper = false)
@Data
public class Sessao extends GenericModel {

    @ManyToOne()
    @JoinColumn(name="fk_usuario_sistema")
    private UsuarioSistema usuarioSistema;
    @Column(name="data_hora_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraLogin;
    @Column
    private String ip;

    public Sessao(UsuarioSistema usuarioSistema, Date dataHoraLogin, String ip) {
        this.usuarioSistema = usuarioSistema;
        this.dataHoraLogin = dataHoraLogin;
        this.ip = ip;
    }

	@Override
	public String toString() {
		return "Sessao [usuarioSistema=" + usuarioSistema + ", dataHoraLogin=" + dataHoraLogin + ", ip=" + ip + "]";
	}
    
}
