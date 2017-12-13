package com.xebia.katabank.transaction.api;

import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.transaction.services.TransactionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value ="/transaction")
public class TransactionRestController implements ITransactionRestApi {

    @Inject
    TransactionService transactionService;

    @RequestMapping(value = "/withdrawal", method = RequestMethod.POST)
    public void postWithdrawal(@RequestBody WithdrawalDTO withdrawalDTO) throws BalanceUnsuffisantException {
        transactionService.makeAAccountWithdrawal(withdrawalDTO.getAccountId(), withdrawalDTO.getAmount(), withdrawalDTO.getCodeCurrency());
    }
}
