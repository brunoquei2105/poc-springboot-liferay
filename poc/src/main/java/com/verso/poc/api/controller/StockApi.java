package com.verso.poc.api.controller;

import com.verso.poc.model.consumer.request.StockRequest;
import com.verso.poc.model.consumer.response.StockResponse;
import com.verso.poc.model.producer.dto.StockDTO;
import com.verso.poc.model.producer.dto.StocksDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Validated
@Tag(name = "Stock API")
public interface StockApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @GetMapping(path = "/all-stocks")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(responses = {
            @ApiResponse(description = "Return a list of StockDTO.", responseCode = "200")
    }, summary = "", tags = {})
    default ResponseEntity<StocksDTO> getStocks(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping(path = "/create-stock")
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(responses = {
            @ApiResponse(description = "Return StockResponse created.", responseCode = "201")
    }, summary = "", tags = {})
    default ResponseEntity<StockResponse> postStock(@RequestBody StockRequest request){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
