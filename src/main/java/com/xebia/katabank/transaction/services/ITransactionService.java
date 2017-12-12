package com.xebia.katabank.transaction.services;

/**
 * Services offerts aux transactions
 */
public interface ITransactionService {
    void makeAAccountWithdrawalInEuro(String accountId, long amount, String codeCurrency);
}
