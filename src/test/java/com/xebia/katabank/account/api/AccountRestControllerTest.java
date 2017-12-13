package com.xebia.katabank.account.api;

import com.xebia.katabank.MainLauncher;
import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.entities.Balance;
import com.xebia.katabank.account.services.GetAccountInformationService;
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
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MainLauncher.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountRestControllerTest {

    @MockBean
    GetAccountInformationService getAccountInformationService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAbout() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        df.setTimeZone(TimeZone.getTimeZone("GMT+0"));

        Currency currency = new Currency("eur", "euro", "€");
        Account account = new Account(UUID.fromString("ac3828b4-dfed-11e7-80c1-9a214cf093ae"), "name", "number", new Balance(new Amount(currency, 100), date));
        Mockito.when(getAccountInformationService.getAccountInformation(account.getId().toString())).thenReturn(account);

        String jsonAccount = "{\"id\":\""+account.getId().toString()+"\",\"name\":\"name\",\"number\":\"number\",\"balance\":{\"amount\":{\"currency\":{\"code\":\"eur\",\"name\":\"euro\",\"symbol\":\"€\"},\"value\":100},\"lastUpdate\":\""+df.format(date)+"\"}}";
        String message = this.restTemplate.getForObject("/accounts/"+account.getId().toString(), String.class);
        assertEquals(jsonAccount, message);
    }

}