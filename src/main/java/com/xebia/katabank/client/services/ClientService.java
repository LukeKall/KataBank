package com.xebia.katabank.client.services;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.repository.IAccountRepository;
import com.xebia.katabank.client.entities.Client;
import com.xebia.katabank.client.portfolio.IClientPortfolio;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ClientService implements  IClientService {

    @Inject
    IClientPortfolio clientPortfolio;

    @Inject
    IAccountRepository accountRepository;

    /**
     * Récupère les information d'un client à partir de son id
     * @param idClient
     * @return
     */
    @Override
    public Client getClientInformation(String idClient){
        return clientPortfolio.getClient(idClient);
    }

    /**
     * Récupère les information d'un client à partir de son login
     * @param login
     * @return
     */
    @Override
    public Client getClientInformationByLogin(String login){
        return clientPortfolio.getClientByLogin(login);
    }

    /**
     * Récupère les comptes d'un client
     * @param idClient
     * @return
     */
    @Override
    public List<Account> getAllClientAccounts(String idClient){
        return accountRepository.getAccountsByClient(idClient);
    }
}
