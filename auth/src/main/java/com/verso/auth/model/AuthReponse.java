package com.verso.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AuthReponse implements Serializable {

    private static final long serialVersionUID = 5469607262231137281L;

    private String userName;
    private String token;

    @JsonProperty("expires_in")
    private int expiresIn;

    @JsonProperty("token_type")
    private String tokenType;
}