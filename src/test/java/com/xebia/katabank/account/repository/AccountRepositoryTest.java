package test.java.com.xebia.katabank.account.repository;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.entities.Balance;
import com.xebia.katabank.account.repository.AccountRepository;
import com.xebia.katabank.money.entities.Amount;
import com.xebia.katabank.money.entities.Currency;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Tests de la classe AccountRepository
 */
public class AccountRepositoryTest {

    @Inject
    AccountRepository accountRepository;

    @Test
    public void testGetAccount(){
        Balance balance = new Balance(new Amount(new Currency("eur", "euro", "€"), 100), new Date());
        Account account = new Account("3a8423bc-df4d-11e7-80c1-9a214cf093ae", UUID.fromString("3a841dea-df4d-11e7-80c1-9a214cf093ae"), "mainAccount", "0112154", balance);
        assertEquals(account, accountRepository.getAccount("3a8423bc-df4d-11e7-80c1-9a214cf093ae"));
    }

    @Test
    public void testAddAccount(){
        Balance balance = new Balance(new Amount(new Currency("eur", "euro", "€"), 100), new Date());
        Account account = new Account("663d5430-df50-11e7-80c1-9a214cf093ae", UUID.fromString("3a841dea-df4d-11e7-80c1-9a214cf093ae"), "mainAccount", "0112154", balance);
        assertNotNull(accountRepository.getAccount("663d5430-df50-11e7-80c1-9a214cf093ae"));
    }

    @Test
    public void testRemoveAccount(){
        AssertNull(accountRepository.removeAccount("3a8423bc-df4d-11e7-80c1-9a214cf093ae"));
    }

    @Test
    public void testUpdateAccount(){
        Balance balance = new Balance(new Amount(new Currency("eur", "euro", "€"), 100), new Date());
        Account account = new Account("3a8423bc-df4d-11e7-80c1-9a214cf093ae", UUID.fromString("3a841dea-df4d-11e7-80c1-9a214cf093ae"), "secondAccount", "0112154", balance);
        accountRepository.updateAccount(account);
        assertEquals("secondAccount", accountRepository.getAccount("3a8423bc-df4d-11e7-80c1-9a214cf093ae").getName());
    }

    @Test
    public void testGetAllAcounts(){
        Balance balance = new Balance(new Amount(new Currency("eur", "euro", "€"), 100), new Date());
        Account account = new Account("663d5430-df50-11e7-80c1-9a214cf093ae", UUID.fromString("3a841dea-df4d-11e7-80c1-9a214cf093ae"), "mainAccount", "0112154", balance);
        List<Account> accountList = accountRepository.getAllAcounts();
        List<Account> accountListTemoin = new ArrayList<>();
        accountListTemoin.add(account);
        accountListTemoin.add(accountRepository.getAccount("3a8423bc-df4d-11e7-80c1-9a214cf093ae"));
        assertEquals(2, accountList.size());
        assertTrue(accountListTemoin.containsAll(accountList));
    }

    @Test
    public void testGetAcountsByClient(){
        Balance balance = new Balance(new Amount(new Currency("eur", "euro", "€"), 100), new Date());
        Account account = new Account("663d5430-df50-11e7-80c1-9a214cf093ae", UUID.fromString("663d57a0-df50-11e7-80c1-9a214cf093ae"), "mainAccount", "0112154", balance);
        List<Account> accountList = accountRepository.getAcountsByClient("663d57a0-df50-11e7-80c1-9a214cf093ae");
        assertEquals(1, accountList.size());
        assertEquals(account, accountList.get(0));
    }
}
