package com.xebia.katabank.transaction.historical;

import com.xebia.katabank.money.entities.Amount;
import com.xebia.katabank.money.entities.Currency;
import com.xebia.katabank.transaction.entities.Transaction;
import com.xebia.katabank.transaction.entities.Withdrawal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests de la classe TransactionHistorical
 */
public class TransactionHistoricalTest {

    @Test
    public void testGetTransaction(){
        TransactionHistorical transactionHistorical = new TransactionHistorical();
        Transaction transaction = new Withdrawal("100c2df0-dfde-11e7-80c1-9a214cf093ae", new Amount(new Currency("eur", "euro", "€"), 50), new Date(), UUID.fromString("3a8423bc-df4d-11e7-80c1-9a214cf093ae"));
        assertEquals(transaction, transactionHistorical.getTransaction("100c2df0-dfde-11e7-80c1-9a214cf093ae"));
    }

    @Test
    public void testAddTransaction(){
        TransactionHistorical transactionHistorical = new TransactionHistorical();
        Transaction transaction = new Withdrawal("100c343a-dfde-11e7-80c1-9a214cf093ae", new Amount(new Currency("eur", "euro", "€"), 50), new Date(), UUID.fromString("3a8423bc-df4d-11e7-80c1-9a214cf093ae"));
        transactionHistorical.addTransaction(transaction);
        assertEquals(transaction, transactionHistorical.getTransaction("100c343a-dfde-11e7-80c1-9a214cf093ae"));
    }

    @Test
    public void testRemoveTransaction(){
        TransactionHistorical transactionHistorical = new TransactionHistorical();
        transactionHistorical.removeTransaction("100c2df0-dfde-11e7-80c1-9a214cf093ae");
        assertNull(transactionHistorical.getTransaction("100c2df0-dfde-11e7-80c1-9a214cf093ae"));
    }

    @Test
    public void testUpdateTransaction(){
        TransactionHistorical transactionHistorical = new TransactionHistorical();
        Transaction transaction = new Withdrawal("100c2df0-dfde-11e7-80c1-9a214cf093ae", new Amount(new Currency("eur", "euro", "€"), 80), new Date(), UUID.fromString("3a8423bc-df4d-11e7-80c1-9a214cf093ae"));
        transactionHistorical.updateTransaction(transaction);
        assertEquals(80, transactionHistorical.getTransaction("100c2df0-dfde-11e7-80c1-9a214cf093ae").getAmount().getValue());
    }

    @Test
    public void testGetAllTransactions(){
        TransactionHistorical transactionHistorical = new TransactionHistorical();
        Transaction transaction = new Withdrawal("100c343a-dfde-11e7-80c1-9a214cf093ae", new Amount(new Currency("eur", "euro", "€"), 80), new Date(), UUID.fromString("3a8423bc-df4d-11e7-80c1-9a214cf093ae"));
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);
        transactionList.add( transactionHistorical.getTransaction("100c2df0-dfde-11e7-80c1-9a214cf093ae"));
        transactionHistorical.addTransaction(transaction);
        List<Transaction> results = transactionHistorical.getAllTransactions();
        assertEquals(2, results.size());
        assertTrue(transactionList.containsAll(results));
    }
}
