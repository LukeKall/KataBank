package com.xebia.katabank.transaction.historical;

import com.xebia.katabank.transaction.entities.Transaction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repository qui stock les transactions en mémoire
 */
@Named
public class TransactionHistorical implements ITransactionHistorical {

    Map<String, Transaction> allTransactions = new HashMap<>();

    @Override
    public Transaction getTransaction(String id) {
        return allTransactions.get(id);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        allTransactions.putIfAbsent(transaction.getId().toString(), transaction);
    }

    @Override
    public void removeTransaction(Transaction transaction) {
        throw new NotImplementedException();
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        throw new NotImplementedException();
    }

    @Override
    public List<Transaction> getAllTransactions() {
        throw new NotImplementedException();
    }
}
