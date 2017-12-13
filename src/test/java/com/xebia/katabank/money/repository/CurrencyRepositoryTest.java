package com.xebia.katabank.money.repository;

import com.xebia.katabank.money.entities.Currency;
import com.xebia.katabank.money.repository.CurrencyRepository;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests de la classe CurrencyRepository
 */
public class CurrencyRepositoryTest {

    @Test
    public void testGetCurrency(){
        CurrencyRepository currencyRepository = new CurrencyRepository();
        Currency currency = new Currency("eur", "euro", "€");
        assertEquals(currency, currencyRepository.getCurrency("eur"));
    }

    @Test
    public void testAddCurrency(){
        CurrencyRepository currencyRepository = new CurrencyRepository();
        Currency currency = new Currency("dol", "dollar", "$");
        currencyRepository.addCurrency(currency);
        assertNotNull(currencyRepository.getCurrency("dol"));
    }

    @Test
    public void testRemoveCurrency(){
        CurrencyRepository currencyRepository = new CurrencyRepository();
        currencyRepository.removeCurrency("eur");
        assertNull(currencyRepository.getCurrency("eur"));
    }

    @Test
    public void testUpdateCurrency(){
        CurrencyRepository currencyRepository = new CurrencyRepository();
        Currency currency = new Currency("eur", "euro2", "€");
        currencyRepository.updateCurrency(currency);
        assertEquals("euro2", currencyRepository.getCurrency("eur").getName());
    }

    @Test
    public void testGetAllCurrencies(){
        CurrencyRepository currencyRepository = new CurrencyRepository();
        Currency currency = new Currency("dol", "dollar", "$");
        currencyRepository.addCurrency(currency);
        List<Currency> currencyListTemoin = new ArrayList<>();
        currencyListTemoin.add(currency);
        currencyListTemoin.add( currencyRepository.getCurrency("eur"));
        List<Currency> results = currencyRepository.GetAllCurrencies();
        assertEquals(2, results.size());
        assertTrue(currencyListTemoin.containsAll(results));
    }
}
