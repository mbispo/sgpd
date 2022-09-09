package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @version 1.0
 * @created 04-nov-2015 14:16:58
 */
@Entity
@Auditavel
@Cacheable
public class Digital implements Serializable {

	private static final long serialVersionUID = 4370874032934100112L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	private Date dataCriacao;
	private Date dataModificacao;
	
	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] imagem;
	
	@Lob @Basic(fetch=FetchType.LAZY)
	private byte[] imagemProcessada;

	public Digital() {
		super();
	}

	public Digital(Long id, Funcionario funcionario, Date dataCriacao, Date dataModificacao, byte[] imagem,
			byte[] imagemProcessada) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
		this.imagem = imagem;
		this.imagemProcessada = imagemProcessada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public byte[] getImagemProcessada() {
		return imagemProcessada;
	}

	public void setImagemProcessada(byte[] imagemProcessada) {
		this.imagemProcessada = imagemProcessada;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		Digital other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "Digital [id=" + id + ", funcionario=" + funcionario + ", dataCriacao=" + dataCriacao
				+ ", dataModificacao=" + dataModificacao + ", imagemProcessada=" + Arrays.toString(imagemProcessada)
				+ "]";
	}

}