package com.xebia.katabank.transaction.api;


public class WithdrawalDTO {

    String accountId;
    long amount;
    String codeCurrency;

    public WithdrawalDTO() {
    }

    public WithdrawalDTO(String accountId, long amount, String codeCurrency) {
        this.accountId = accountId;
        this.amount = amount;
        this.codeCurrency = codeCurrency;
    }

    public String getAccountId() {
        return accountId;
    }

    public long getAmount() {
        return amount;
    }

    public String getCodeCurrency() {
        return codeCurrency;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setCodeCurrency(String codeCurrency) {
        this.codeCurrency = codeCurrency;
    }
}
