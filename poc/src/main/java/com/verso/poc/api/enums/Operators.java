package com.verso.poc.api.enums;

public enum Operators {

    EQUAL("eq"), NOT_EQUAL("ne"), GREATER_THAN("gt"), GREATER_THAN_OR_EQUAL("ge"), LESS_THAN("lt"),
    LESS_THAN_OR_EQUAL("le"), STARS_WITH("sw"), AND("and"), OR("or"), NOT("not"), SIGN_EQUAL("="), SIGN_AND("&"),
    SIGN_DOUBLEPOINTS(":");

    private String operator;

    Operators(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static String addFilter(String field, Operators filter, long value) {
        return String.format("?filter=%s %s %d", field, filter.getOperator(), value);
    }

    public static String addFilter(String field, Operators filter, int value) {
        return String.format("?filter=%s %s %d", field, filter.getOperator(), value);
    }

    public static String addSearch(String field, Operators filter, long value) {
        return String.format("?search=%s %s %d", field, filter.getOperator(), value);
    }

    public static String addPageSize(int pageSize) {
        return String.format("?%s%s%d", Filters.PAGE_SIZE.getFilter(), Operators.SIGN_EQUAL.getOperator(), pageSize);
    }

    public static String addFilter(String field, Operators filter, String value) {
        return String.format("?filter=%s %s '%s'", field, filter.getOperator(), value);
    }
}
