package com.xebia.katabank.money.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test de la classe Currency
 */
public class CurrencyTest {

    @Test
    public void testConvertAmountValueInAnotherCurrency(){
        Currency currency = new Currency("eur", "eur", "€");
        Currency newCurrency = new Currency("dol", "dol", "$");
        assertEquals(10, currency.convertAmountValueInAnotherCurrency(10, newCurrency));
    }
}
