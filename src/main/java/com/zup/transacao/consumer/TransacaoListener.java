package com.zup.transacao.consumer;

import com.zup.transacao.model.Cartao;
import com.zup.transacao.model.Estabelecimento;
import com.zup.transacao.model.Transacao;
import com.zup.transacao.repository.CartaoRepository;
import com.zup.transacao.repository.EstabelecimentoRepository;
import com.zup.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class TransacaoListener {

    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;
    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(MensagemTransacao eventoDeTransacao) {

       Optional<Cartao> possivelCartao = cartaoRepository.findById(eventoDeTransacao.getCartao().getId());
        Cartao cartao;
        if(possivelCartao.isEmpty()) {
            cartao = new Cartao(eventoDeTransacao.getCartao());
            cartaoRepository.save(cartao);
        } else {
            cartao = possivelCartao.get();
        }

        Optional<Estabelecimento> possivelEstabelecimento = estabelecimentoRepository
                .findByNomeAndEndereco(eventoDeTransacao.getEstabelecimento().getNome(),
                        eventoDeTransacao.getEstabelecimento().getEndereco());
        Estabelecimento estabelecimento;
        if(possivelEstabelecimento.isEmpty()) {
            estabelecimento = new Estabelecimento(eventoDeTransacao.getEstabelecimento());
            estabelecimentoRepository.save(estabelecimento);
        } else {
            estabelecimento = possivelEstabelecimento.get();
        }

        Transacao novaTransacao = new Transacao(eventoDeTransacao, cartao, estabelecimento);
        transacaoRepository.save(novaTransacao);
        System.out.println(novaTransacao);
    }
}
