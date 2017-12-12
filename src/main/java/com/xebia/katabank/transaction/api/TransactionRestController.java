package com.xebia.katabank.transaction.api;

import com.xebia.katabank.transaction.services.TransactionService;

@RestController
@RequestMapping(value ="/transaction")
public class TransactionRestController implements ITransactionRestApi {

    @Inject
    TransactionService transactionService;

    @RequestMapping(value = "/withdrawal", method = RequestMethod.POST)
    public void postWithdrawal(@RequestBody WithdrawalDTO withdrawalDTO){
        transactionService.makeAAccountWithdrawal(withdrawalDTO.getAccountId(), withdrawalDTO.getAmount(), withdrawalDTO.getCodeCurrency());
    }
}
