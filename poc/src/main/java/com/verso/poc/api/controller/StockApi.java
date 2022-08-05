package com.verso.poc.api.controller;

import com.verso.poc.model.consumer.request.StockRequest;
import com.verso.poc.model.consumer.response.StockResponse;
import com.verso.poc.model.producer.dto.StockDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Validated
public interface StockApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @GetMapping(path = "/all-stocks")
    @ResponseStatus(value = HttpStatus.OK)
    default ResponseEntity<List<StockDTO>> getStocks(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping(path = "/create-stock")
    @ResponseStatus(value = HttpStatus.CREATED)
    default ResponseEntity<StockResponse> postStock(@RequestBody StockRequest request){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
