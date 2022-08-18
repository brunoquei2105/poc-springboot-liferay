package com.verso.poc.api.controller.impl;

import com.verso.poc.api.controller.interfaces.StockApi;
import com.verso.poc.api.enums.Operators;
import com.verso.poc.api.facade.objects.StockFacade;
import com.verso.poc.api.factory.objects.StockFactory;
import com.verso.poc.model.consumer.response.objects.StockResponseRoot;
import com.verso.poc.model.producer.objects.StocksDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(path = "/v1/api")
@Slf4j
public class StockController implements StockApi {

    private final StockFacade stockFacade;

    private final StockFactory factory;

    public StockController(StockFacade stockFacade, StockFactory factory){

        this.stockFacade = stockFacade;
        this.factory = factory;
    }

    public ResponseEntity<StocksDTO> getStocks(){
        var dto = new StocksDTO();
        StockResponseRoot root = stockFacade.getAllStocks(Operators.addPageSize(-1));

        if (Objects.nonNull(root) && Objects.nonNull(root.getStocks()) && root.getStocks().size() > 0){

            dto = factory.setStocksDto(root);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
