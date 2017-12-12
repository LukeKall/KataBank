package test.java.com.xebia.katabank.transaction.services;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.money.entities.Currency;
import com.xebia.katabank.transaction.entities.Transaction;
import com.xebia.katabank.transaction.services.TransactionService;

/**
 * Tests de la classe TransactionService
 */
public class TransactionServiceTest {

    @Inject
    TransactionService transactionService;

    @Test
    public void testMakeAAccountWithdrawal() throws BalanceUnsuffisantException {
        Account account = new Account();
        Currency currency = new Currency();
        transactionService.makeAAccountWithdrawal("id", 10, "eur");
    }
}
