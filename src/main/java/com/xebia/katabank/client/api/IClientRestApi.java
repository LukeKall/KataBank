package com.xebia.katabank.client.api;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.client.entities.Client;

import java.util.List;

public interface IClientRestApi {

    Client getClientByLogin(String login);
    List<Account> getClientById(String idClient);
}
