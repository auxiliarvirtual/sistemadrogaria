package br.com.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_itens")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ite_codigo")
	private Long codigo;

	@Column(name = "ite_valor_parcial", precision = 7, scale = 2, nullable = false)
	private BigDecimal valor;

	@Column(name = "ite_quantidade", nullable = false)
	private Integer quantidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_venda_ven_codigo", referencedColumnName = "ven_codigo", nullable = false)
	private Venda venda;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_produto_pro_codigo", referencedColumnName = "pro_codigo", nullable = false)
	private Produto produto;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

}
