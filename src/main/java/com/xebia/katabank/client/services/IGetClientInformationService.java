package com.xebia.katabank.client.services;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.client.entities.Client;

import java.util.List;

/**
 * Services offerts à un client
 */
public interface IGetClientInformationService {
    Client getClientInformation(String idClient);
    Client getClientInformationByLogin(String login);
    List<Account> getAllClientAccounts(String idClient);
}
