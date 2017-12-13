package com.xebia.katabank.money.repository;

import com.xebia.katabank.money.entities.Currency;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repository qui stock les devises en mémoire
 */
@Named
public class CurrencyRepository implements ICurrencyRepository {

    Map<String, Currency> allCurrencies = new HashMap<>();

    public CurrencyRepository() {
        Currency currency = new Currency("eur", "euro", "€");
        allCurrencies.put(currency.getCode(), currency);
    }

    @Override
    public Currency getCurrency(String code) {
        return allCurrencies.get(code);
    }

    @Override
    public void addCurrency(Currency currency) {
        allCurrencies.put(currency.getCode(), currency);
    }

    @Override
    public void removeCurrency(String code) {
        allCurrencies.remove(code);
    }

    @Override
    public void updateCurrency(Currency currency) {
        if(allCurrencies.containsKey(currency.getCode())) {
            allCurrencies.put(currency.getCode(), currency);
        }
    }

    @Override
    public List<Currency> GetAllCurrencies() {
        return new ArrayList<>(allCurrencies.values());
    }
}
