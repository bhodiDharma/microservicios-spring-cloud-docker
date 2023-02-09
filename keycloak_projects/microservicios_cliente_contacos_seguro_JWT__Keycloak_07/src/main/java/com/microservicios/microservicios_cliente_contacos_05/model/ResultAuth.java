package com.microservicios.microservicios_cliente_contacos_05.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultAuth {

    @JsonProperty("access_token")
    private String accessToken;

    public ResultAuth() {
    }

    public ResultAuth(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
