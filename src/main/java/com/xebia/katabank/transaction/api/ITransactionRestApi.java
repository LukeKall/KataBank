package com.xebia.katabank.transaction.api;

import com.xebia.katabank.account.error.BalanceUnsuffisantException;

public interface ITransactionRestApi {

    void postWithdrawal(WithdrawalDTO withdrawalDTO) throws BalanceUnsuffisantException;
}
