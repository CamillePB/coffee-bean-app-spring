package coffeebeanapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo")
public class Tipo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tipo")
	private List<MarcaTipo> marcaTipo;

	public List<MarcaTipo> getMarcaTipo() {
		return marcaTipo;
	}

	public void setMarcaTipo(List<MarcaTipo> marcaTipo) {
		this.marcaTipo = marcaTipo;
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
	
	
}