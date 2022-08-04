package com.verso.poc.api.enums;

public enum Filters {

    CODIGO_STOCK("code"),
    ID_STOCKS("idStocks"),
    PAGE_SIZE("pageSize"),
    DATE_CREATED("dateCreated"),
    MODIFIED_DATE("dateModified");
    private String filter;

    Filters(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }
}
