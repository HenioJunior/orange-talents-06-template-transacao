package com.zup.transacao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;
import com.zup.transacao.consumer.MensagemTransacao;

@Entity
public class Transacao {

	@Id
	private String id;
	@NotNull
	@Positive
	private BigDecimal valor;
	@NotNull
	@Valid
	@ManyToOne
	private Cartao cartao;
	@NotNull
	@Valid
	@ManyToOne
	private Estabelecimento estabelecimento;
	@NotNull
	@PastOrPresent
	private LocalDateTime efetivadaEm;
	
	@Deprecated
	public Transacao() {
		super();
	}

	public Transacao(MensagemTransacao eventoDeTransacao, @NotNull @Valid Cartao cartao,
			@NotNull @Valid Estabelecimento estabelecimento) {
		this.id = eventoDeTransacao.getId();
		this.valor = eventoDeTransacao.getValor();
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = eventoDeTransacao.getEfetivadaEm();
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	@Override
	public String toString() {
		return "Transacao{" +
				", id='" + id + '\'' +
				", valor=" + valor +
				", cartao=" + cartao +
				", estabelecimento=" + estabelecimento +
				", efetivadaEm=" + efetivadaEm +
				'}';
	}
}
