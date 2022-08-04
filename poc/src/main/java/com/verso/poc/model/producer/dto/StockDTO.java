package com.verso.poc.model.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {

    private String code;
    private String name_stock;
    private String value;
    private String volume;
    private String dateCreated;
}
