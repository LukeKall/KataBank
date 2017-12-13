package com.xebia.katabank.transaction.historical;

import com.xebia.katabank.money.entities.Amount;
import com.xebia.katabank.money.entities.Currency;
import com.xebia.katabank.transaction.entities.Transaction;
import com.xebia.katabank.transaction.entities.Withdrawal;

import javax.inject.Named;
import java.util.*;

/**
 * Repository qui stock les transactions en mémoire
 */
@Named
public class TransactionHistorical implements ITransactionHistorical {

    Map<String, Transaction> allTransactions = new HashMap<>();

    public TransactionHistorical(){
        Transaction transaction = new Withdrawal("100c2df0-dfde-11e7-80c1-9a214cf093ae", new Amount(new Currency("eur", "euro", "€"), 50), new Date(), UUID.fromString("3a8423bc-df4d-11e7-80c1-9a214cf093ae"));
        allTransactions.put(transaction.getId().toString(), transaction);
    }

    @Override
    public Transaction getTransaction(String id) {
        return allTransactions.get(id);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        allTransactions.putIfAbsent(transaction.getId().toString(), transaction);
    }

    @Override
    public void removeTransaction(String id) {
        allTransactions.remove(id);
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        if(allTransactions.containsKey(transaction.getId().toString())) {
            allTransactions.put(transaction.getId().toString(), transaction);
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(allTransactions.values());
    }
}
