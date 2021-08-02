package com.zup.transacao;

import com.zup.transacao.dto.Transacao;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoListener {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(Transacao transacao) {
        System.out.println("Transação: " + transacao.toString());
    }

}
