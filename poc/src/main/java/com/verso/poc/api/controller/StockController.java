package com.verso.poc.api.controller;

import com.verso.poc.api.enums.Operators;
import com.verso.poc.api.facade.StockFacade;
import com.verso.poc.api.factory.StockFactory;
import com.verso.poc.model.consumer.response.StockResponse;
import com.verso.poc.model.consumer.response.StockResponseRoot;
import com.verso.poc.model.producer.dto.StockDTO;
import com.verso.poc.model.producer.dto.StocksDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/v1/api")
@Slf4j
public class StockController implements StockApi{

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
