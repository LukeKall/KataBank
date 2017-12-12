package com.xebia.katabank.transaction.historical;

import com.xebia.katabank.transaction.entities.Transaction;

import java.util.List;

/**
 * Repository permettant de gérer la persistance des transactions
 */
public interface ITransactionHistorical {

    Transaction getTransaction(String id);
    void addTransaction(Transaction transaction);
    void removeTransaction(Transaction transaction);
    void updateTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
}
