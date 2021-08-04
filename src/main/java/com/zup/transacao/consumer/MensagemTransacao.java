package com.zup.transacao.consumer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MensagemTransacao {

    private String id;
    private BigDecimal valor;
    private MensagemEstabelecimento estabelecimento;
    private MensagemCartao cartao;
    private LocalDateTime efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public MensagemEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public MensagemCartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}