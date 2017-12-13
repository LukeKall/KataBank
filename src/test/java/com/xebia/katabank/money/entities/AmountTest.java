package com.xebia.katabank.money.entities;

import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.money.entities.Amount;
import com.xebia.katabank.money.entities.Currency;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.eq;

/**
 * Test de la classe Amount
 */
public class AmountTest {

    @Test
    public void testConvertInAnotherCurrency(){
        Currency currency = Mockito.mock(Currency.class);
        Currency amountCurrency = Mockito.mock(Currency.class);
        Mockito.when(amountCurrency.convertAmountValueInAnotherCurrency(Mockito.anyLong(), eq(currency))).then(i -> i.getArgument(0));
        Amount amount = new Amount(amountCurrency, 100);
        amount.convertInAnotherCurrency(currency);
        assertEquals(100, amount.getValue());
        assertEquals(currency, amount.getCurrency());
    }

    @Test
    public void testIsSuperiorThan(){
        Currency currencySupperior = Mockito.mock(Currency.class);
        Currency currency = Mockito.mock(Currency.class);
        Mockito.when(currency.convertAmountValueInAnotherCurrency(Mockito.anyLong(), eq(currencySupperior))).then(i -> i.getArgument(0));
        Mockito.when(currencySupperior.convertAmountValueInAnotherCurrency(Mockito.anyLong(), eq(currency))).then(i -> i.getArgument(0));
        Amount amount = new Amount(currency, 100);
        Amount amountSuperior = new Amount(currencySupperior, 150);
        assertFalse(amount.isSuperiorThan(amountSuperior));
        assertTrue(amountSuperior.isSuperiorThan(amount));
    }

    @Test
    public void testDebit(){
        Currency currencySup= Mockito.mock(Currency.class);
        Currency currency = Mockito.mock(Currency.class);
        Mockito.when(currency.convertAmountValueInAnotherCurrency(Mockito.anyLong(), eq(currencySup))).then(i -> i.getArgument(0));
        Mockito.when(currencySup.convertAmountValueInAnotherCurrency(Mockito.anyLong(), eq(currency))).then(i -> i.getArgument(0));
        Amount amount = new Amount(currency, 100);
        Amount amountSup = new Amount(currencySup, 150);
        amountSup.debit(amount);
        assertEquals(50, amountSup.getValue());
    }
}
