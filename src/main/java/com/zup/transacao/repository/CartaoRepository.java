package com.zup.transacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.transacao.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, String> {

}
