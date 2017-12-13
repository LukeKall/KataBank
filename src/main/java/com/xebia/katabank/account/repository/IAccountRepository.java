package com.xebia.katabank.account.repository;

import com.xebia.katabank.account.entities.Account;

import java.util.List;

/**
 * Repository pour gérer la persistance des comptes bancaires
 */
public interface IAccountRepository {
    Account getAccount(String id);
    void addAccount(Account account);
    void removeAccount(String id);
    void updateAccount(Account account);
    List<Account> getAllAcounts();
    List<Account> getAccountsByClient(String clientId);
}
