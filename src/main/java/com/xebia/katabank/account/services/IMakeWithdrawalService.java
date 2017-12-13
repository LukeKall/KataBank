package com.xebia.katabank.account.services;

import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.transaction.entities.Transaction;

/**
 * Services offerts aux transactions
 */
public interface IMakeWithdrawalService {
    Transaction makeAAccountWithdrawal(String accountId, long amount, String codeCurrency) throws BalanceUnsuffisantException;
}
