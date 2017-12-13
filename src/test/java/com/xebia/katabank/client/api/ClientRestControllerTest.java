package com.xebia.katabank.client.api;

import com.xebia.katabank.MainLauncher;
import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.entities.Balance;
import com.xebia.katabank.client.entities.Client;
import com.xebia.katabank.client.services.ClientService;
import com.xebia.katabank.money.entities.Amount;
import com.xebia.katabank.money.entities.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MainLauncher.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientRestControllerTest {

    @MockBean
    ClientService clientService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetClientByLogin(){
        Client client = new Client("login", "lastname", "firstname");
        Mockito.when(clientService.getClientInformationByLogin("login")).thenReturn(client);
        String message = this.restTemplate.getForObject("/client/login", String.class);
        String jsonClient = "{\"id\":\""+client.getId().toString()+"\",\"login\":\"login\",\"lastName\":\"lastname\",\"firstName\":\"firstname\"}";
        assertEquals(jsonClient, message);
    }

    @Test
    public void testGetAllAccountsById(){
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        df.setTimeZone(TimeZone.getTimeZone("GMT+0"));

        Currency currency = new Currency("eur", "euro", "€");
        Client client = new Client("login", "lastname", "firstname");
        List<Account> accountList = new ArrayList<>();
        Account account = new Account(client.getId(), "name", "number", new Balance(new Amount(currency, 100), date));
        accountList.add(account);

        Mockito.when(clientService.getAllClientAccounts(client.getId().toString())).thenReturn(accountList);
        String message = this.restTemplate.getForObject("/client/accounts/" + client.getId().toString(), String.class);
        String jsonClient = "[{\"id\":\""+account.getId().toString()+"\",\"name\":\"name\",\"number\":\"number\",\"balance\":{\"amount\":{\"currency\":{\"code\":\"eur\",\"name\":\"euro\",\"symbol\":\"€\"},\"value\":100},\"lastUpdate\":\""+df.format(date)+"\"}}]";
        assertEquals(jsonClient, message);
    }
}
