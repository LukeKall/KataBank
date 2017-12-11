package com.xebia.katabank.Transaction;

import com.xebia.katabank.Account.Account;
import com.xebia.katabank.Account.IAccountRepository;
import com.xebia.katabank.Money.Currency;
import com.xebia.katabank.Money.ICurrencyRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class TransactionsService {

    @Inject
    IAccountRepository accountRepository;

    @Inject
    ICurrencyRepository currencyRepository;

    @Inject
    ITransactionRepository transactionRepository;

    public void makeAAccountWithdrawalInEuro(String accountId, long amount, String codeCurrency) {
        Account account = accountRepository.getAccount(accountId);
        Currency currency = currencyRepository.getCurrency(codeCurrency);
        Transaction transaction = account.makeAWithdrawal(amount, currency);
        transactionRepository.addTransaction(transaction);
        accountRepository.updateAccount(account);
    }
}
