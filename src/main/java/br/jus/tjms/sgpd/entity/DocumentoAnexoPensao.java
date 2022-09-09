package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import br.jus.tjms.sgpd.enumerators.TipoDocumentoAnexoPensao;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 12-abr-2016 13:36:00
 */

@Entity
@Auditavel
@Cacheable
public class DocumentoAnexoPensao implements Serializable {

	private static final long serialVersionUID = -8655876353969125036L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date data;

	@ManyToOne
	@JoinColumn(name = "pensao_id", nullable = false)
	private Pensao pensao;

	@Enumerated(EnumType.ORDINAL)
	private TipoDocumentoAnexoPensao tipo;

	@ManyToOne
	@JoinColumn(name = "fornecedor_id", nullable = true)
	private Funcionario fornecedor;

	@ManyToOne
	@JoinColumn(name = "juntaMedica_id", nullable = true)
	private JuntaMedica juntaMedica;

	@Column(length = 200)
	private String descricao;

	private Long idDocumento;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] integra;

	public DocumentoAnexoPensao() {
		super();
	}

	public DocumentoAnexoPensao(Date data, Pensao pensao, TipoDocumentoAnexoPensao tipo, Funcionario fornecedor,
			JuntaMedica juntaMedica, String descricao, Long idDocumento, byte[] integra) {
		super();
		this.data = data;
		this.pensao = pensao;
		this.tipo = tipo;
		this.fornecedor = fornecedor;
		this.juntaMedica = juntaMedica;
		this.descricao = descricao;
		this.idDocumento = idDocumento;
		this.integra = integra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Pensao getPensao() {
		return pensao;
	}

	public void setPensao(Pensao pensao) {
		this.pensao = pensao;
	}

	public TipoDocumentoAnexoPensao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDocumentoAnexoPensao tipo) {
		this.tipo = tipo;
	}

	public Funcionario getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Funcionario fornecedor) {
		this.fornecedor = fornecedor;
	}

	public JuntaMedica getJuntaMedica() {
		return juntaMedica;
	}

	public void setJuntaMedica(JuntaMedica juntaMedica) {
		this.juntaMedica = juntaMedica;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}

	public byte[] getIntegra() {
		return integra;
	}

	public void setIntegra(byte[] integra) {
		this.integra = integra;
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
		DocumentoAnexoPensao other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "DocumentoAnexoPensao [id=" + id + ", data=" + data + ", pensao=" + pensao + ", tipo=" + tipo
				+ ", fornecedor=" + fornecedor + ", juntaMedica=" + juntaMedica + ", descricao=" + descricao
				+ ", idDocumento=" + idDocumento + "]";
	}

}