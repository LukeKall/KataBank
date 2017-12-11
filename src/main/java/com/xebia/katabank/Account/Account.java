package com.xebia.katabank.Account;

import com.xebia.katabank.Money.Amount;
import com.xebia.katabank.Money.Balance;
import com.xebia.katabank.Money.Currency;
import com.xebia.katabank.Transaction.Transaction;
import com.xebia.katabank.Transaction.Withdrawal;

import java.util.Date;
import java.util.UUID;

public class Account {

    private UUID id;
    private UUID clientId;
    private String name;
    private String number;
    private Balance balance;

    public Account(UUID clientId, String name, String number, Balance balance) {
        this.id = UUID.randomUUID();
        this.clientId = clientId;
        this.name = name;
        this.number = number;
        this.balance = balance;
    }

    public Account(String id, UUID clientId, String name, String number, Balance balance) {
        this.id = UUID.fromString(id);
        this.clientId = clientId;
        this.name = name;
        this.number = number;
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public Transaction makeAWithdrawal(long amountValue, Currency currency) {
        Amount amount = new Amount(currency, amountValue);
        if(!balance.isBalanceSuffisant(amount)) {

        }
        Transaction withdrawal = new Withdrawal();
        this.debit(amount, withdrawal.getDate());
        return withdrawal;
    }

    public void debit(Amount amount, Date dateDebit){
        this.balance.debit(amount, dateDebit);
    }

    public boolean isClientPropriety(UUID clientId){
        return this.clientId == clientId;
    }

}
