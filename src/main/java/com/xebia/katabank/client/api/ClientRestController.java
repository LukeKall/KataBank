package com.xebia.katabank.client.api;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.client.entities.Client;
import com.xebia.katabank.client.services.ClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(value ="/client")
public class ClientRestController implements IClientRestApi{

    @Inject
    ClientService clientService;

    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public Client getClientByLogin(@PathVariable(value = "login") String login){
        return clientService.getClientInformationByLogin(login);
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    public List<Account> getClientById(@PathVariable(value = "id") String idClient){
        return clientService.getAllClientAccounts(idClient);
    }

}
