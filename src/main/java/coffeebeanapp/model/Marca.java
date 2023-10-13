package coffeebeanapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_marca")
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToOne
	@JsonIgnoreProperties("marca")
	private Tipo tipo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "marca", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("marca")
	private List<ClienteMarca> clienteMarca;
	
	public List<ClienteMarca> getClienteMarca() {
		return clienteMarca;
	}

	public void setClienteMarca(List<ClienteMarca> clienteMarca) {
		this.clienteMarca = clienteMarca;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
}
