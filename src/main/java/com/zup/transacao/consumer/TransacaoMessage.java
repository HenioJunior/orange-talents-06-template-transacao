package com.zup.transacao.consumer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.zup.transacao.dto.CartaoResponse;
import com.zup.transacao.dto.EstabelecimentoResponse;
import com.zup.transacao.model.Cartao;
import com.zup.transacao.model.Estabelecimento;
import com.zup.transacao.model.Transacao;

public class TransacaoMessage {
	
	private String id;

	private BigDecimal valor;

	private EstabelecimentoResponse estabelecimento;

	private CartaoResponse cartao;

	private LocalDateTime efetivadaEm;

	public TransacaoMessage(String id, BigDecimal valor, EstabelecimentoResponse estabelecimento, CartaoResponse cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoResponse getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	
	public Transacao toModel() {
		Estabelecimento estabelecimento = this.estabelecimento.toModel();
		Cartao cartao = this.cartao.toModel();
		return new Transacao(this.id, this.valor, cartao, estabelecimento ,this.efetivadaEm);

	}
		
}
