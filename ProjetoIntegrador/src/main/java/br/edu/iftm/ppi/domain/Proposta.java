package br.edu.iftm.ppi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Proposta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descrição;
	private String prazo;
	
	@ManyToOne
	@JoinColumn(name="fazenda_id")
	private Fazenda fazendaProposta;
	
	@JsonIgnore
	@OneToMany(mappedBy="propostaOrcamento")
	private List<Orcamento> orcamentos = new ArrayList<>();
	
	
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="orcamentoEscolhido_id")
	@MapsId
	private Orcamento orcamentoFinal;
//	
//	@OneToOne(cascade=CascadeType.ALL, mappedBy="pagamentoProposta")
//	private Proposta propostaPagamento;
	
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="pagamento_id")
	@MapsId
	private Pagamento pagamentoProposta;
//	
	
	public Proposta(){}

	public Proposta(Integer id, String descrição, String prazo) {
		super();
		this.id = id;
		this.descrição = descrição;
		this.prazo = prazo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
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
		Proposta other = (Proposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
