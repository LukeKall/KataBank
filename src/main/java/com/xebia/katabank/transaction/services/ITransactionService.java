package com.xebia.katabank.transaction.services;

import com.xebia.katabank.account.error.BalanceUnsuffisantException;

/**
 * Services offerts aux transactions
 */
public interface ITransactionService {
    void makeAAccountWithdrawal(String accountId, long amount, String codeCurrency) throws BalanceUnsuffisantException;
}
