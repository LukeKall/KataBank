package com.xebia.katabank.transaction.services;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.account.repository.IAccountRepository;
import com.xebia.katabank.money.entities.Currency;
import com.xebia.katabank.money.repository.ICurrencyRepository;
import com.xebia.katabank.transaction.historical.ITransactionHistorical;
import com.xebia.katabank.transaction.entities.Transaction;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class TransactionService implements ITransactionService {

    @Inject
    IAccountRepository accountRepository;

    @Inject
    ICurrencyRepository currencyRepository;

    @Inject
    ITransactionHistorical transactionHistorical;

    /**
     * Permet de réaliser un retrait bancaire
     * @param accountId
     * @param amount
     * @param codeCurrency
     * @throws BalanceUnsuffisantException
     */
    @Override
    public void makeAAccountWithdrawal(String accountId, long amount, String codeCurrency) throws BalanceUnsuffisantException {
        Account account = accountRepository.getAccount(accountId);
        Currency currency = currencyRepository.getCurrency(codeCurrency);
        Transaction transaction = account.makeAWithdrawal(amount, currency);
        transactionHistorical.addTransaction(transaction);
        accountRepository.updateAccount(account);
    }
}
