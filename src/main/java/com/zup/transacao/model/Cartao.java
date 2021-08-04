package com.zup.transacao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.zup.transacao.consumer.MensagemCartao;

@Entity
public class Cartao {

    @Id	
	private String id;
    @Email
    @NotBlank
    private String email;

    @Deprecated
    public Cartao() {
    }
   
    public Cartao(MensagemCartao cartao) {
        this.id = cartao.getId();
        this.email = cartao.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
	public String toString() {
		return "Cartao [id=" + id + ", email=" + email + "]";
	}
 }
