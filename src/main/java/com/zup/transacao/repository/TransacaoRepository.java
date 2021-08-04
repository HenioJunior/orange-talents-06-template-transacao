package com.zup.transacao.repository;

import com.zup.transacao.model.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {


	Optional<Transacao> findByCartao(String cartao);


	Page<Transacao> findByCartaoId(String cartaoId, Pageable pageable);


}
