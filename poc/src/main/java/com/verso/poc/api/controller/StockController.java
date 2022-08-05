package com.verso.poc.api.controller;

import com.verso.poc.api.enums.Filters;
import com.verso.poc.api.enums.Operators;
import com.verso.poc.api.facade.StockFacade;
import com.verso.poc.model.consumer.response.StockResponse;
import com.verso.poc.model.consumer.response.StockResponseRoot;
import com.verso.poc.model.producer.dto.StockDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/v1/api")
public class StockController implements StockApi{

    private final StockFacade stockFacade;

    public StockController(StockFacade stockFacade){
        this.stockFacade = stockFacade;
    }

    public ResponseEntity<List<StockDTO>> getStocks(){
        List<StockDTO> dtos = new ArrayList<>();

        StockResponseRoot root = stockFacade.getAllStocks(Operators.addPageSize(-1));

        if (Objects.nonNull(root) && Objects.nonNull(root.getStocks()) && root.getStocks().size() > 0){
            var dto = new StockDTO();
            for (StockResponse stock : root.getStocks()){
                dto.setName_stock(stock.getName_stock());
                dto.setCode(stock.getCode());
                dto.setValue(String.valueOf(stock.getValue()));
                dto.setVolume(String.valueOf(stock.getVolume()));
                dto.setDateCreated(stock.getDateCreated());

                dtos.add(dto);
            }
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
