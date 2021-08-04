package com.zup.transacao.dto;

import com.zup.transacao.model.Cartao;
import com.zup.transacao.model.Estabelecimento;
import com.zup.transacao.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoRequest {

    private String id;
    private BigDecimal valor;
    private Cartao cartao;
    private Estabelecimento estabelecimento;
    private LocalDateTime efetivadaEm;
       

    public TransacaoRequest(Transacao transacao, Cartao cartao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.cartao = cartao;
        this.estabelecimento = transacao.getEstabelecimento();
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

        
}
