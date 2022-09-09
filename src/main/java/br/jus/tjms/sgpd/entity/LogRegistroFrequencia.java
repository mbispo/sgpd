package br.jus.tjms.sgpd.entity;

import br.jus.tjms.auditor.annotation.Auditavel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @created 06-nov-2015 16:30:59
 */
@Entity
@Auditavel
@Cacheable
public class LogRegistroFrequencia implements Serializable {

	private static final long serialVersionUID = -1056563510131351335L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = true)
	private Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "local_id", nullable = false)
	private LocalRegistroFrequencia local;

	@Column(length = 255)
	private String usuario;

	@Column(length = 255)
	private String tipo;

	@Column(length = 255)
	private String operacao;

	@Column(length = 255)
	private String classe;

	@Column(length = 255)
	private String metodo;

	private Date dataHora;

	@Column(length = 500)
	private String mensagem;

	public LogRegistroFrequencia() {
		super();
	}

	public LogRegistroFrequencia(Long id, Funcionario funcionario, LocalRegistroFrequencia local, String usuario,
			String tipo, String operacao, String classe, String metodo, Date dataHora, String mensagem) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.local = local;
		this.usuario = usuario;
		this.tipo = tipo;
		this.operacao = operacao;
		this.classe = classe;
		this.metodo = metodo;
		this.dataHora = dataHora;
		this.mensagem = mensagem;
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

	public LocalRegistroFrequencia getLocal() {
		return local;
	}

	public void setLocal(LocalRegistroFrequencia local) {
		this.local = local;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
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
		LogRegistroFrequencia other = this.getClass().cast(obj);
		return new EqualsBuilder().append(id, other.getId()).isEquals();
	}

	@Override
	public String toString() {
		return "LogRegistroFrequencia [id=" + id + ", funcionario=" + funcionario + ", local=" + local + ", usuario="
				+ usuario + ", tipo=" + tipo + ", operacao=" + operacao + ", classe=" + classe + ", metodo=" + metodo
				+ ", dataHora=" + dataHora + ", mensagem=" + mensagem + "]";
	}

}