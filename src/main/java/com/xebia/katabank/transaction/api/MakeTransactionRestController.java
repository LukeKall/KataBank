package com.xebia.katabank.transaction.api;

import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.account.services.IMakeWithdrawalService;
import com.xebia.katabank.transaction.entities.Transaction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value ="/transactions")
public class MakeTransactionRestController implements IMakeTransactionRestApi {

    @Inject
    IMakeWithdrawalService makeWithdrawalService;

    @RequestMapping(value = "/withdrawal", method = RequestMethod.POST)
    public Transaction postWithdrawal(@RequestBody WithdrawalDTO withdrawalDTO) throws BalanceUnsuffisantException {
        return makeWithdrawalService.makeAAccountWithdrawal(withdrawalDTO.getAccountId(), withdrawalDTO.getAmount(), withdrawalDTO.getCodeCurrency());
    }
}
