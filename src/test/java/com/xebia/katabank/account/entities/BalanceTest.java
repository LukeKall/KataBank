package com.xebia.katabank.account.entities;

import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.money.entities.Amount;
import com.xebia.katabank.money.entities.Currency;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests de la classe Balance
 */
public class BalanceTest {

    @Test
    public void testIsBalanceSuffisantForDebit(){
        Amount amount = Mockito.mock(Amount.class);
        Amount amountSup = Mockito.mock(Amount.class);
        Balance balance = new Balance(amount, new Date());
        Mockito.when(amount.isSuperiorThan(amountSup)).thenReturn(false);
        Mockito.when(amountSup.isSuperiorThan(amount)).thenReturn(true);
        assertFalse(balance.isBalanceSuffisantForDebit(amountSup));

        balance = new Balance(amountSup, new Date());
        assertTrue(balance.isBalanceSuffisantForDebit(amount));
    }

    @Test
    public void testDebit() throws BalanceUnsuffisantException {
        Amount balanceAmount = Mockito.mock(Amount.class);
        Amount amount = new Amount(new Currency("eur", "eur", "eur"), 50);

        Mockito.when(balanceAmount.isSuperiorThan(amount)).thenReturn(true);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        Balance balance = new Balance(balanceAmount, calendar.getTime());
        Date date = new Date();
        Mockito.doNothing().when(balanceAmount).debit(amount);
        balance.debit(amount, date);

        assertEquals(date, balance.getLastUpdate());

        Mockito.when(balanceAmount.isSuperiorThan(amount)).thenReturn(false);
        Balance balance2 = new Balance(balanceAmount, calendar.getTime());

        assertThrows(BalanceUnsuffisantException.class, ()-> {balance2.debit(amount, date);});
        assertNotEquals(date, balance2.getLastUpdate());
    }

    @Test
    public void testDebitDependsOfAmount() throws BalanceUnsuffisantException {
        Amount amount = new Amount(new Currency("eur", "eur", "eur"), 50);
        Amount balanceAmount = new Amount(new Currency("eur", "eur", "eur"), 200);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        Balance balance = new Balance(balanceAmount, calendar.getTime());
        Date date = new Date();
        balance.debit(amount, date);

        assertEquals(date, balance.getLastUpdate());
        assertEquals(150, balance.getAmount().getValue());

    }
}
