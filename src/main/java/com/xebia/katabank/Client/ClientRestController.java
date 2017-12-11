package com.xebia.katabank.Client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value ="/client")
public class ClientRestController {

    @Inject
    ClientService clientService;

    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public Client getClientByLogin(@PathVariable(value = "login") String login){
        return clientService.getClientInformationByLogin(login);
    }

}
