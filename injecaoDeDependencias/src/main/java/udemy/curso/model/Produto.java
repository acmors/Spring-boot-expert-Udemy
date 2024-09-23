package udemy.curso.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class Produto {
	
	private Integer id;
	private String descricao;
	private BigDecimal precoUnd;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco_und() {
		return precoUnd;
	}
	public void setPreco_und(BigDecimal preco_und) {
		this.precoUnd = preco_und;
	}
	
	
}
