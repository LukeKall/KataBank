package com.xebia.katabank.Money;

public class Currency {

    private String code;
    private String name;
    private String symbol;

    public Currency(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public long convertAmountValueInAnotherCurrency(long amount, Currency currency) {
        return amount;
    }
}
