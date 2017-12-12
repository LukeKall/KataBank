package test.java.com.xebia.katabank.account.entities;

import com.xebia.katabank.account.entities.Balance;
import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.money.entities.Amount;

import java.util.Date;

/**
 * Tests de la classe Balance
 */
public class BalanceTest {

    @Test
    public void testIsBalanceSuffisantForDebit(){
        Balance balance = new Balance();
        Amount amountOk = new Amount();
        Amount amountNok = new Amount();
        assertTrue(balance.isBalanceSuffisantForDebit(amountOk));
        assertFalse(balance.isBalanceSuffisantForDebit(amountNok));
    }

    @Test
    public void testDebit() throws BalanceUnsuffisantException {
        Balance balance = new Balance();
        Amount amount = new Amount();
        Date date = new Date();
        balance.debit(amount, date);
        assertEquals(date, balance.getLastUpdate());
        assertEquals(10, balance.getAmount().getValue());
    }
}
