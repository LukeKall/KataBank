package com.xebia.katabank.Money;

import java.util.List;

public interface ICurrencyRepository {

    Currency getCurrency(String code);
    void addCurrency(Currency currency);
    void removeCurrency(Currency currency);
    void updateCurrency(Currency currency);
    List<Currency> GetAllCurrencies();

}
