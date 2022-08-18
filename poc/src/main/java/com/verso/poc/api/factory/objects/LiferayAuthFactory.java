package com.verso.poc.api.factory.objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class LiferayAuthFactory {

    @Value("${uri.headless.liferay.auth.clientid}")
    private String clientId;

    @Value("${uri.headless.liferay.auth.secret}")
    private String client_secret;

    @Value("${uri.headless.liferay.auth.granttype}")
    private String grantedType;

    public MultiValueMap<String, String> getRequestBody(){
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("client_id", clientId);
        bodyValues.add("client_secret", client_secret);
        bodyValues.add("grant_type", grantedType);
        return bodyValues;
    }
}
