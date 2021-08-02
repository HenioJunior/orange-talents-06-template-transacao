package com.zup.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacao {

    private String id;

    private BigDecimal valor;

    private LocalDateTime efetivadaEm;

    private CartaoDto cartaoDto;

    private Estabelecimento estabelecimento;

    @Override
    public String toString() {
        return "Transacao{" +
                "Id = '" + id + '\'' +
                ", Valor = " + valor +
                ", EfetivadaEm = " + efetivadaEm +
                ", Id do cartao = " + cartaoDto.getId() +
                ", Email do cartao = " + cartaoDto.getEmail() +
                ", Nome do estabelecimento = " + estabelecimento.getNome() +
                ", Endereco do estabelecimento = " + estabelecimento.getEndereco() +
                ", Cidade do estabelecimento = " + estabelecimento.getCidade() +
                '}';
    }
}
