package com.xebia.katabank.account.entities;

import com.xebia.katabank.account.error.BalanceUnsuffisantException;
import com.xebia.katabank.money.entities.Amount;
import com.xebia.katabank.money.entities.Currency;
import com.xebia.katabank.transaction.entities.Transaction;
import com.xebia.katabank.transaction.entities.Withdrawal;

import java.util.Date;
import java.util.UUID;

/**
 * Représente un compte bancaire
 */
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

    /**
     * Permet de réaliser un retrait bancaire
     * @param amountValue
     * @param currency
     * @return
     * @throws BalanceUnsuffisantException
     */
    public Transaction makeAWithdrawal(long amountValue, Currency currency) throws BalanceUnsuffisantException {
        Amount amount = new Amount(currency, amountValue);
        if(!balance.isBalanceSuffisantForDebit(amount)) {
            throw new BalanceUnsuffisantException();
        }
        Transaction withdrawal = new Withdrawal(amount, new Date(), this.id);
        this.debit(amount, withdrawal.getDate());
        return withdrawal;
    }

    /**
     * Débite le compte
     * @param amount
     * @param dateDebit
     */
    public void debit(Amount amount, Date dateDebit) throws BalanceUnsuffisantException {
        this.balance.debit(amount, dateDebit);
    }

    /**
     * Vérifie si un client est propriétaire du compte
     * @param clientId
     * @return
     */
    public boolean isClientPropriety(UUID clientId){
        return this.clientId == clientId;
    }

}
