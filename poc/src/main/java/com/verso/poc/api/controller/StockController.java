package com.verso.poc.api.controller;

import com.verso.poc.api.facade.StockFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/api")
public class StockController implements StockApi{

    private final StockFacade stockFacade;

    public StockController(StockFacade stockFacade){
        this.stockFacade = stockFacade;
    }
}
