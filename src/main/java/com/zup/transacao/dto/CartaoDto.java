package com.zup.transacao.dto;

import java.util.UUID;

public class CartaoDto {

    private String id;
    private String email;

    public CartaoDto() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
