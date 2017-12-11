package com.xebia.katabank.Client;

import com.xebia.katabank.Account.Account;
import com.xebia.katabank.Account.IAccountRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ClientService {

    @Inject
    IClientRepository clientRepository;

    @Inject
    IAccountRepository accountRepository;

    public Client getClientInformation(String idClient){
        return clientRepository.getClient(idClient);
    }

    public Client getClientInformationByLogin(String login){
        return clientRepository.getClientByLogin(login);
    }

    public List<Account> getAllClientAccounts(String idClient){
        return accountRepository.getAcountsByClient(idClient);
    }
}
