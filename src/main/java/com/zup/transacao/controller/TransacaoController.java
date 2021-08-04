package com.zup.transacao.controller;

import com.zup.transacao.model.Transacao;
import com.zup.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cartoes")
public class TransacaoController {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@GetMapping
	public ResponseEntity<Map<String, Object>> listaUltimasTransacoes(
			@RequestParam(required = false) String cartaoId,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "efetivadaEm") String orderBy
			){

		try {
			List<Transacao> transacoes = new ArrayList<Transacao>();
			Pageable paging = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
			System.out.println(">>>>>>>" + cartaoId);
			Page<Transacao> pageTransacao;
			if (cartaoId == null)
				pageTransacao = transacaoRepository.findAll(paging);
			else
				pageTransacao = transacaoRepository.findByCartaoId(cartaoId, paging);

			transacoes = pageTransacao.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("transacoes", transacoes);
			response.put("currentPage", pageTransacao.getNumber());
			response.put("totalItems", pageTransacao.getTotalElements());
			response.put("totalPages", pageTransacao.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//
//	private Cartao getCartao(String idCartao) {
//		Optional<Cartao> obj = cartaoRepository.findById(idCartao);
//		Cartao cartao = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
//		return cartao;
//	}

}
