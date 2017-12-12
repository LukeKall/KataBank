package test.java.com.xebia.katabank.money.entities;

import com.xebia.katabank.money.entities.Amount;
import com.xebia.katabank.money.entities.Currency;

/**
 * Test de la classe Amount
 */
public class AmountTest {

    @Test
    public void testIsSuperiorThan(){
        Amount amount = new Amount();
        Amount amountSuperior = new Amount();
        assertFalse(amount.isSuperiorThan(amountSuperior));
        assertTrue(amountSuperior.isSuperiorThan(amount));
    }

    @Test
    public void testDebit(){
        Amount amount = new Amount();
        Amount amountToDebit = new Amount();
        amount.debit(amountToDebit);
        assertEquals(10, amount.getValue());
    }

    @Test
    public void testConvertInAnotherCurrency(){
        Amount amount = new Amount();
        Currency newCurrency = new Currency();
        amount.convertInAnotherCurrency(newCurrency);
        assertEquals(10, amount.getValue());
        assertEquals(newCurrency, amount.getCurrency());
    }
}
