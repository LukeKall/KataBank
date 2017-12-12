package com.xebia.katabank.account.api;

import com.xebia.katabank.account.entities.Account;

public interface IAccountRestApi {
    Account getAccountById(String idAccount);
}
