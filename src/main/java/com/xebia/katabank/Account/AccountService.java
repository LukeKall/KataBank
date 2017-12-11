package com.xebia.katabank.Account;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AccountService {

    @Inject
    IAccountRepository accountRepository;

    public Account getAccountInformation(String accountId){
        return accountRepository.getAccount(accountId);
    }
}
