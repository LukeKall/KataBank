package com.xebia.katabank.money.repository;

import com.xebia.katabank.money.entities.Currency;

import java.util.List;

/**
 * Repository pour gérer la persistance des devises
 */
public interface ICurrencyRepository {

    Currency getCurrency(String code);
    void addCurrency(Currency currency);
    void removeCurrency(Currency currency);
    void updateCurrency(Currency currency);
    List<Currency> GetAllCurrencies();

}
