package com.xebia.katabank.transaction.services;

import com.xebia.katabank.MockitoExtension;
import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.account.repository.IAccountRepository;
import com.xebia.katabank.money.entities.Amount;
import com.xebia.katabank.money.entities.Currency;
import com.xebia.katabank.money.repository.ICurrencyRepository;
import com.xebia.katabank.transaction.entities.Transaction;
import com.xebia.katabank.transaction.entities.Withdrawal;
import com.xebia.katabank.transaction.historical.ITransactionHistorical;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests de la classe TransactionService
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class TransactionServiceTest {

    @Mock
    IAccountRepository accountRepository;

    @Mock
    ICurrencyRepository currencyRepository;

    @Mock
    ITransactionHistorical transactionHistorical;

    @InjectMocks
    TransactionService transactionService;

    @Test
    public void testMakeAAccountWithdrawal() throws BalanceUnsuffisantException {
        List<Transaction> transactionList = new ArrayList<>();
        List<Account> accountList = new ArrayList<>();

        Currency currency = new Currency("eur", "euro", "€");
        Account account = Mockito.mock(Account.class);
        Mockito.when(accountRepository.getAccount("id")).thenReturn(account);
        Mockito.when(currencyRepository.getCurrency("eur")).thenReturn(currency);
        Transaction transaction = new Withdrawal(new Amount(currency, 50), new Date(), UUID.randomUUID());
        Mockito.when(account.makeAWithdrawal(10, currency)).thenReturn(transaction);

        Answer<Void> answerTransaction = new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Transaction transaction = invocation.getArgument(0);
                transactionList.add(transaction);
                return null;
            }
        };

        Answer<Void> answerAccount = new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Account account = invocation.getArgument(0);
                accountList.add(account);
                return null;
            }
        };

        Mockito.doAnswer(answerTransaction).when(transactionHistorical).addTransaction(transaction);
        Mockito.doAnswer(answerAccount).when(accountRepository).updateAccount(account);

        transactionService.makeAAccountWithdrawal("id", 10, "eur");

        assertTrue(transactionList.contains(transaction));
        assertTrue(accountList.contains(account));

    }
}
