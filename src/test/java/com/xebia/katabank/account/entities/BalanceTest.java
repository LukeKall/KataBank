package com.xebia.katabank.account.entities;

import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.money.entities.Amount;
import com.xebia.katabank.money.entities.Currency;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests de la classe Balance
 */
public class BalanceTest {

    @Test
    public void testIsBalanceSuffisantForDebit(){
        Currency currency = new Currency("eur", "euro", "€");
        Amount amount = new Amount(currency, 100);
        Amount amountSup = new Amount(currency, 150);
        Balance balance = new Balance(amount, new Date());
        assertFalse(balance.isBalanceSuffisantForDebit(amountSup));

        balance = new Balance(amountSup, new Date());
        assertTrue(balance.isBalanceSuffisantForDebit(amount));
    }

    @Test
    public void testDebit() throws BalanceUnsuffisantException {
        Currency currency = new Currency("eur", "euro", "€");
        Amount balanceAmount =new Amount(currency, 200);
        Amount amount = new Amount(currency, 50);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        Balance balance = new Balance(balanceAmount, calendar.getTime());
        Date date = new Date();
        balance.debit(amount, date);

        assertEquals(date, balance.getLastUpdate());
        assertEquals(150, balance.getAmount().getValue());

        Balance balance2 = new Balance(amount, calendar.getTime());

        assertThrows(BalanceUnsuffisantException.class, ()-> {balance.debit(balanceAmount, date);});
        assertNotEquals(date, balance2.getLastUpdate());
    }
}
