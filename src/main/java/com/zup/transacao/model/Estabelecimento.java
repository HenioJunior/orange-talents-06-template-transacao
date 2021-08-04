package com.zup.transacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.zup.transacao.consumer.MensagemEstabelecimento;

@Entity
public class Estabelecimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String cidade;
	@NotBlank
	private String endereco;

    @Deprecated
	public Estabelecimento() {
    }
    
    public Estabelecimento(MensagemEstabelecimento estabelecimento) {
        this.nome = estabelecimento.getNome();
        this.endereco = estabelecimento.getEndereco();
        this.cidade = estabelecimento.getCidade();
    }
    

	public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
