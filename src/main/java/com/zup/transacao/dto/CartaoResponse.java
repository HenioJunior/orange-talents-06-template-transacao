package com.zup.transacao.dto;

import com.zup.transacao.model.Cartao;

public class CartaoResponse {
	
	private String id;
    private String email;
	
    public CartaoResponse(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	
	public Cartao toModel() {
        return new Cartao(this.id, this.email);
    }
    
   }
