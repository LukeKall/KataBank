package com.xebia.katabank.account.services;

import com.xebia.katabank.account.entities.Account;

/**
 * Services offerts par un compte bancaire
 */
public interface IAccountService {

    Account getAccountInformation(String accountId);
}
