package com.verso.poc.model.consumer.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockResponse {

    @JsonProperty("id")
    private long id;

    @JsonProperty("idStocks")
    private long id_stock;

    @JsonProperty("code")
    private String code;

    @JsonProperty("namestock")
    private String name_stock;

    @JsonProperty("value")
    private BigDecimal value;

    @JsonProperty("volume")
    private BigDecimal volume;

    @JsonProperty("dateCreated")
    private String dateCreated;

}
