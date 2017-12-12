package com.xebia.katabank.transaction.api;

public interface ITransactionRestApi {

    void postWithdrawal(WithdrawalDTO withdrawalDTO);
}
