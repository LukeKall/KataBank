package com.xebia.katabank.Account;

import java.util.List;

public interface IAccountRepository {
    Account getAccount(String id);
    void addAccount(Account account);
    void removeAccount(Account account);
    void updateAccount(Account account);
    List<Account> getAllAcounts();
    List<Account> getAcountsByClient(String clientId);
}
