package com.zup.transacao.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zup.transacao.model.Transacao;
import com.zup.transacao.repository.CartaoRepository;
import com.zup.transacao.repository.EstabelecimentoRepository;
import com.zup.transacao.repository.TransacaoRepository;

@Component
public class ArmazenaTransacaoComponent {

	@Autowired
	private TransacaoRepository transacaoRespository;

	@Autowired
	private CartaoRepository cartaoRespository;

	@Autowired
	private EstabelecimentoRepository estabelecimentoRespository;

	public void TransformaEvento(TransacaoMessage transacaoMessage) {
		Transacao transacaoModel = transacaoMessage.toModel();
		cartaoRespository.save(transacaoModel.getCartao());
		estabelecimentoRespository.save(transacaoModel.getEstabelecimento());
		transacaoRespository.save(transacaoModel);
	}

}
