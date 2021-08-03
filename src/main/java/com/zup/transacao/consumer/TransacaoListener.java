package com.zup.transacao.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoListener {

	private ArmazenaTransacaoComponent armazenaTransacaoComponent;
	
	public TransacaoListener(ArmazenaTransacaoComponent armazenaTransacaoComponent) {
		this.armazenaTransacaoComponent = armazenaTransacaoComponent;
	}

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	public void listen(TransacaoMessage transacaoMessage) {
		armazenaTransacaoComponent.TransformaEvento(transacaoMessage);

		System.out.println("Transação: " + transacaoMessage);
	}

}
