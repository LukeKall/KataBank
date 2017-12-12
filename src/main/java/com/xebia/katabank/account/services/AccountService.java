package com.xebia.katabank.account.services;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.repository.IAccountRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AccountService implements IAccountService{

    @Inject
    IAccountRepository accountRepository;

    /**
     * Récupère un compte bancaire à partir de son id
     * @param accountId
     * @return
     */
    @Override
    public Account getAccountInformation(String accountId){
        return accountRepository.getAccount(accountId);
    }
}
