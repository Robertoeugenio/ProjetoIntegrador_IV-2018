package br.edu.iftm.ppi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orcamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Double preco;
	private String descricao;
	private Date dataOrcamento;
	
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuarioOrcamento;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="proposta_id")
	private Proposta propostaOrcamento;
//	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="orcamentoFinal")
	private Proposta propostaEscolhida;
	
	
	
	public Orcamento(){}


	public Orcamento(Integer id, Double preco, String descricao, Date dataOrcamento) {
		super();
		this.id = id;
		this.preco = preco;
		this.descricao = descricao;
		this.dataOrcamento = dataOrcamento;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Date getDataOrcamento() {
		return dataOrcamento;
	}


	public void setDataOrcamento(Date dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
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
		Orcamento other = (Orcamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
