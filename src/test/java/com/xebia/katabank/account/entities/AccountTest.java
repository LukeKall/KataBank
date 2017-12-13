package com.xebia.katabank.account.entities;

import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.money.entities.Amount;
import com.xebia.katabank.money.entities.Currency;
import com.xebia.katabank.transaction.entities.Transaction;
import com.xebia.katabank.transaction.entities.Withdrawal;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test de la classe Account
 */
public class AccountTest {

    @Test
    public void testIsClientPropriety(){
        Account account = new Account(UUID.fromString("100c3a52-dfde-11e7-80c1-9a214cf093ae"), "name", "number", Mockito.mock(Balance.class));
        assertTrue(account.isClientPropriety(UUID.fromString("100c3a52-dfde-11e7-80c1-9a214cf093ae")));
        assertFalse(account.isClientPropriety(UUID.fromString("100c3d72-dfde-11e7-80c1-9a214cf093ae")));
    }

    @Test
    public void testDebitDependsOfBalance() throws BalanceUnsuffisantException {
        Currency currency = new Currency("eur", "euro", "€");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        Account account = new Account(UUID.fromString("100c3a52-dfde-11e7-80c1-9a214cf093ae"), "name", "number", new Balance(new Amount(currency, 50), calendar.getTime()));
        Date date = new Date();

        Amount amountToDebit = new Amount(currency, 30);

        account.debit(amountToDebit, date);
        assertEquals(20, account.getBalance().getAmount().getValue());
        assertEquals(date, account.getBalance().getLastUpdate());

        assertThrows(BalanceUnsuffisantException.class, ()-> {account.debit(amountToDebit, date);});
    }

    @Test
    public void testMakeAWithdrawal() throws BalanceUnsuffisantException {
        Balance balance = Mockito.mock(Balance.class);
        Account account = new Account(UUID.fromString("100c3a52-dfde-11e7-80c1-9a214cf093ae"), "name", "number", balance);
        Mockito.when(balance.isBalanceSuffisantForDebit(Mockito.any(Amount.class))).thenReturn(true);
        Transaction transaction = account.makeAWithdrawal(50, Mockito.mock(Currency.class));
        assertTrue(transaction instanceof Withdrawal);
        assertEquals(50, transaction.getAmount().getValue());
        assertEquals(account.getId(), ((Withdrawal)transaction).getDebitAccountId());

        Mockito.when(balance.isBalanceSuffisantForDebit(Mockito.any(Amount.class))).thenReturn(false);
        assertThrows(BalanceUnsuffisantException.class, ()-> {account.makeAWithdrawal(50,  Mockito.mock(Currency.class));});
    }
}
