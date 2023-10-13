package coffeebeanapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente_marca")
public class ClienteMarca {
	
	private Long quantidade;
	
	private String data;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clienteMarca", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("clienteMarca")
	private List<Marca> marca;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clienteMarca", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("clienteMarca")
	private List<Cliente> cliente;

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Marca> getMarca() {
		return marca;
	}

	public void setMarca(List<Marca> marca) {
		this.marca = marca;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

}
