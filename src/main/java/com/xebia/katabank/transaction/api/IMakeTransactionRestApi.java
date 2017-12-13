package com.xebia.katabank.transaction.api;

import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.transaction.entities.Transaction;

public interface IMakeTransactionRestApi {

    Transaction postWithdrawal(WithdrawalDTO withdrawalDTO) throws BalanceUnsuffisantException;
}
