package com.xebia.katabank.money.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test de la classe Amount
 */
public class AmountTest {

    @Test
    public void testConvertInAnotherCurrency(){
        Currency currency = new Currency("eur", "euro", "€");
        Currency currency2 = new Currency("dol", "dollar", "$");
        Amount amount = new Amount(currency, 100);
        amount.convertInAnotherCurrency(currency2);
        assertEquals(100, amount.getValue());
        assertEquals(currency2, amount.getCurrency());
    }

    @Test
    public void testIsSuperiorThan(){
        Currency currency = new Currency("eur", "euro", "€");
        Currency currency2 = new Currency("dol", "dollar", "$");
        Amount amount = new Amount(currency, 100);
        Amount amountSuperior = new Amount(currency2, 150);
        assertFalse(amount.isSuperiorThan(amountSuperior));
        assertTrue(amountSuperior.isSuperiorThan(amount));
    }

    @Test
    public void testDebit(){
        Currency currency = new Currency("eur", "euro", "€");
        Currency currency2 = new Currency("dol", "dollar", "$");
        Amount amount = new Amount(currency, 100);
        Amount amountSup = new Amount(currency2, 150);
        amountSup.debit(amount);
        assertEquals(50, amountSup.getValue());
    }
}
