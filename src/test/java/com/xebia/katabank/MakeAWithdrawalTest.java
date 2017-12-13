package com.xebia.katabank;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.account.repository.AccountRepository;
import com.xebia.katabank.account.services.GetAccountInformationService;
import com.xebia.katabank.account.services.IGetAccountInformationService;
import com.xebia.katabank.client.entities.Client;
import com.xebia.katabank.client.portfolio.ClientPortfolio;
import com.xebia.katabank.client.services.GetClientInformationService;
import com.xebia.katabank.client.services.IGetClientInformationService;
import com.xebia.katabank.money.repository.CurrencyRepository;
import com.xebia.katabank.transaction.entities.Transaction;
import com.xebia.katabank.transaction.entities.Withdrawal;
import com.xebia.katabank.transaction.historical.TransactionHistorical;
import com.xebia.katabank.account.services.IMakeWithdrawalService;
import com.xebia.katabank.account.services.MakeWithdrawalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {GetClientInformationService.class, MakeWithdrawalService.class, GetAccountInformationService.class, ClientPortfolio.class, AccountRepository.class, CurrencyRepository.class, TransactionHistorical.class})
public class MakeAWithdrawalTest {

    @Inject
    IMakeWithdrawalService makeWithdrawalService;

    @Inject
    IGetAccountInformationService getAccountInformationService;

    @Inject
    IGetClientInformationService getClientInformationService;

    @Test
    public void testMakeAwithdrawal() throws BalanceUnsuffisantException {

        String login = "pierre-jean";
        Client client = getClientInformationService.getClientInformationByLogin(login);
        assertNotNull(client);

        List<Account> accountList = getClientInformationService.getAllClientAccounts(client.getId().toString());
        assertEquals(1, accountList.size());

        Account account = accountList.get(0);
        assertEquals(100, account.getBalance().getAmount().getValue());

        Transaction transaction = makeWithdrawalService.makeAAccountWithdrawal(account.getId().toString(), 10, "eur");
        assertNotNull(transaction);
        assertTrue(transaction instanceof Withdrawal);
        assertEquals(10, transaction.getAmount().getValue());

        Withdrawal withdrawal = (Withdrawal) transaction;
        assertEquals(account.getId(), withdrawal.getDebitAccountId());

        account = getAccountInformationService.getAccountInformation(withdrawal.getDebitAccountId().toString());
        assertNotNull(account);
        assertEquals(90, account.getBalance().getAmount().getValue());
    }
}
