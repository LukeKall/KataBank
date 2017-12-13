package com.xebia.katabank;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.account.repository.AccountRepository;
import com.xebia.katabank.account.services.AccountService;
import com.xebia.katabank.account.services.IAccountService;
import com.xebia.katabank.client.entities.Client;
import com.xebia.katabank.client.portfolio.ClientPortfolio;
import com.xebia.katabank.client.services.ClientService;
import com.xebia.katabank.client.services.IClientService;
import com.xebia.katabank.money.repository.CurrencyRepository;
import com.xebia.katabank.transaction.historical.TransactionHistorical;
import com.xebia.katabank.transaction.services.ITransactionService;
import com.xebia.katabank.transaction.services.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {ClientService.class, TransactionService.class, AccountService.class, ClientPortfolio.class, AccountRepository.class, CurrencyRepository.class, TransactionHistorical.class})
public class MakeAWithdrawalTest {

    @Inject
    ITransactionService transactionService;

    @Inject
    IAccountService accountService;

    @Inject
    IClientService clientService;

    @Test
    public void testMakeAwithdrawal() throws BalanceUnsuffisantException {

        String login = "pierre-jean";
        Client client = clientService.getClientInformationByLogin(login);
        assertNotNull(client);

        List<Account> accountList = clientService.getAllClientAccounts(client.getId().toString());
        assertEquals(1, accountList.size());

        Account account = accountList.get(0);
        assertEquals(100, account.getBalance().getAmount().getValue());

        transactionService.makeAAccountWithdrawal(account.getId().toString(), 10, "eur");

        account = accountService.getAccountInformation(account.getId().toString());
        assertNotNull(account);
        assertEquals(90, account.getBalance().getAmount().getValue());
    }
}
