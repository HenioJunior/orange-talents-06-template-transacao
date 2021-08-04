package com.zup.transacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.transacao.model.Estabelecimento;

import java.util.Optional;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

    Optional<Estabelecimento> findByNomeAndEndereco(String nome, String endereco);
		
}
