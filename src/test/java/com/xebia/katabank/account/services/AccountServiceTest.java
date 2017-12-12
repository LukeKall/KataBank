package test.java.com.xebia.katabank.account.services;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.services.AccountService;

/**
 * Tests de la classe AccountService
 */
public class AccountServiceTest {

    @Test
    public void getAccountInformation(){
        AccountService accountService = new AccountService();
        Account account = new Account();
        assertEquals(account, accountService.getAccountInformation());
    }
}
