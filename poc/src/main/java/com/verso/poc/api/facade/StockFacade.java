package com.verso.poc.api.facade;

import com.verso.poc.model.consumer.request.StockRequest;
import com.verso.poc.model.consumer.response.StockResponse;
import com.verso.poc.model.consumer.response.StockResponseRoot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class StockFacade {

    @Value("${base.url.liferay.object}")
    private String baseUrl;

    @Value("${uri.object.stock}")
    private String objectStockURI;

    @Value("${uri.object.stock.put}")
    private String objectStockPutURI;

    public StockResponseRoot getAllStocks(String filter){
        WebClient webClient = WebClient.create(baseUrl);

        return webClient.get().uri(objectStockURI + filter)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(StockResponseRoot.class)
                .block();
    }

    public StockResponse createstock(StockRequest request){
        WebClient webClient = WebClient.create(baseUrl);

        return webClient.post().uri(objectStockURI)
                .bodyValue(request)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(StockResponse.class)
                .block();
    }

    public StockResponse updateStock(long id, StockRequest request){
        WebClient webClient = WebClient.create(baseUrl);

        return webClient.put().uri(uriBuilder -> uriBuilder.path(objectStockPutURI).build(id))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(StockResponse.class)
                .block();
    }
}