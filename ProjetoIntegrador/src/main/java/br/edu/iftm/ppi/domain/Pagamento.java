package br.edu.iftm.ppi.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
    //atenção mudar esse atributo e seus relacionados para o tipo enum
	private String estadoPagamento;
	private Integer numeroPrestacao;

	public Pagamento(){}

	public Pagamento(Integer id, String estadoPagamento, Integer numeroPrestacao) {
		super();
		this.id = id;
		this.estadoPagamento = estadoPagamento;
		this.numeroPrestacao = numeroPrestacao;
	}
	
//	@JsonIgnore
//	@OneToOne
//	@JoinColumn(name="pagamento_id")
//	@MapsId
//	private Proposta proposta;
	
//	@OneToOne(cascade=CascadeType.ALL, mappedBy="pagamentoProposta")
//	private Proposta propostaPagamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstadoPagamento() {
		return estadoPagamento;
	}

	public void setEstadoPagamento(String estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}

	public Integer getNumeroPrestacao() {
		return numeroPrestacao;
	}

	public void setNumeroPrestacao(Integer numeroPrestacao) {
		this.numeroPrestacao = numeroPrestacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
