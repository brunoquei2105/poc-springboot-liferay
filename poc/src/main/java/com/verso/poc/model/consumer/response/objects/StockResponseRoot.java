package com.verso.poc.model.consumer.response.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class StockResponseRoot {

    @JsonProperty("items")
    private List<StockResponse> stocks;
}
