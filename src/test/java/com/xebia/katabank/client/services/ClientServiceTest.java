package test.java.com.xebia.katabank.client.services;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.client.entities.Client;
import com.xebia.katabank.client.services.ClientService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Tests de la classe ClientService
 */
public class ClientServiceTest {

    @Inject
    ClientService clientService;

    @Test
    public void testGetClientInformation(){
        Client client = new Client();
        assertEquals(client, clientService.getClientInformation("id"));
    }

    @Test
    public void testGetClientInformationByLogin(){
        Client client = new Client();
        assertEquals(client, clientService.getClientInformationByLogin("login"));
    }

    @Test
    public void testGetAllClientAccounts(){
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account());
        accountList.add(new Account());
        assertTrue(accountList.containsAll(clientService.getAllClientAccounts("id")));
    }
}
