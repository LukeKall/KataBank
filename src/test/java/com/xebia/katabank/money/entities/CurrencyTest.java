package test.java.com.xebia.katabank.money.entities;

import com.xebia.katabank.money.entities.Currency;

/**
 * Test de la classe Currency
 */
public class CurrencyTest {

    @Test
    public testConvertAmountValueInAnotherCurrency(){
        Currency currency = new Currency();
        Currency newCurrency = new Currency();
        assertEquals(10, currency.convertAmountValueInAnotherCurrency(10, newCurrency));
    }
}
