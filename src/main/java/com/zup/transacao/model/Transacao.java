package com.zup.transacao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String id;

	private BigDecimal valor;

	private LocalDateTime efetivadaEm;

	@ManyToOne
	private Cartao cartao;

	@ManyToOne
	private Estabelecimento estabelecimento;

	public Transacao(String id, BigDecimal valor, Cartao cartao,
			Estabelecimento estabelecimento, LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.cartao = cartao;
		this.estabelecimento = estabelecimento;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

}
