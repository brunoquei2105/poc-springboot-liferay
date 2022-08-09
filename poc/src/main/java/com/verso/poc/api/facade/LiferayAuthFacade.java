package com.verso.poc.api.facade;

import com.verso.poc.api.factory.LiferayAuthFactory;
import com.verso.poc.model.consumer.response.LiferayAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class LiferayAuthFacade {

    @Value("${base.url.liferay.object}")
    private String baseURL;

    @Value("${uri.headless.liferay.auth}")
    private String authURI;

    @Autowired
    private LiferayAuthFactory authFactory;

    public LiferayAuthResponse getAuth(){

        WebClient webClient = WebClient.create(baseURL);

        return webClient.post().uri(authURI).contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(authFactory.getRequestBody()))
                .retrieve()
                .bodyToMono(LiferayAuthResponse.class)
                .block();
    }
}
