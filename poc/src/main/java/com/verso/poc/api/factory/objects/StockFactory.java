package com.verso.poc.api.factory.objects;

import com.verso.poc.model.consumer.response.objects.StockResponse;
import com.verso.poc.model.consumer.response.objects.StockResponseRoot;
import com.verso.poc.model.producer.objects.StockDTO;
import com.verso.poc.model.producer.objects.StocksDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StockFactory {

    public StockDTO setStockDTO(StockResponse stock){
        var dto = new StockDTO();
        dto.setCode(stock.getCode());
        dto.setName_stock(stock.getName_stock());
        dto.setVolume(String.valueOf(stock.getVolume()));
        dto.setDateCreated(stock.getDateCreated());
        dto.setValue(String.valueOf(stock.getValue()));
        return dto;
    }

    public StocksDTO setStocksDto(StockResponseRoot root){
        StocksDTO dtos = new StocksDTO();
        List<StockResponse> response = root.getStocks();
        List<StockDTO> stocksDTO = new ArrayList<>();

        for (StockResponse stock : response){
            stocksDTO.add(setStockDTO(stock));
        }
        dtos.setStocks(stocksDTO);

        return dtos;
    }
}
