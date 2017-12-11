package com.xebia.katabank.Transaction;

import java.util.List;

public interface ITransactionRepository {

    Transaction getTransaction(String id);
    void addTransaction(Transaction transaction);
    void removeTransaction(Transaction transaction);
    void updateTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
}
