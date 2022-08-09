package com.verso.poc.model.consumer.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LiferayAuthResponse {

    @JsonProperty("access_token")
    public String accessToken;

    @JsonProperty("token_type")
    public String tokenType;

    @JsonProperty("expires_in")
    public int expiresIn;

    @JsonProperty("scope")
    public String scope;

    @JsonProperty("refresh_token")
    public String refreshToken;
}

/*
Example of returned call to WB http://localhost:8080/o/auth2/token
{
	"access_token": "[authorization server generated access token]",
	"token_type": "Bearer",
	"expires_in": 600,
	"scope": "[the scopes that were authorized by the user]",
	"refresh_token": "[authorization server generated refresh token]"
}
 */
