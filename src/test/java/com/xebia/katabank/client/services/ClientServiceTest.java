package com.xebia.katabank.client.services;

import com.xebia.katabank.extension.MockitoExtension;
import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.entities.Balance;
import com.xebia.katabank.account.repository.AccountRepository;
import com.xebia.katabank.client.entities.Client;
import com.xebia.katabank.client.portfolio.ClientPortfolio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests de la classe ClientService
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ClientServiceTest {

    @Mock
    ClientPortfolio clientPortfolio;

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    ClientService clientService;

    @Test
    public void testGetClientInformation(){
        Client client = new Client("login", "lastName", "firstName");
        Mockito.when(clientPortfolio.getClient(client.getId().toString())).thenReturn(client);
        assertEquals(client, clientService.getClientInformation(client.getId().toString()));
    }

    @Test
    public void testGetClientInformationByLogin(){
        Client client = new Client("login", "lastName", "firstName");
        Mockito.when(clientPortfolio.getClientByLogin("login")).thenReturn(client);
        assertEquals(client, clientService.getClientInformationByLogin("login"));
    }

    @Test
    public void testGetAllClientAccounts(){
        List<Account> accountList = new ArrayList<>();
        UUID id = UUID.randomUUID();
        accountList.add(new Account(id, "name", "number", Mockito.mock(Balance.class)));
        accountList.add(new Account(id, "name2", "number2", Mockito.mock(Balance.class)));
        Mockito.when(accountRepository.getAccountsByClient(id.toString())).thenReturn(accountList);
        assertTrue(accountList.containsAll(clientService.getAllClientAccounts(id.toString())));
    }
}
