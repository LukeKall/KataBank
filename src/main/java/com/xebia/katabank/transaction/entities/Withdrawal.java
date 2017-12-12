package com.xebia.katabank.transaction.entities;

import com.xebia.katabank.money.entities.Amount;

import java.util.Date;
import java.util.UUID;

/**
 * Représente un retrait bancaire
 */
public class Withdrawal extends Transaction {

    private UUID debitAccountId;

    public Withdrawal(Amount amount, Date date, UUID debitAccountId) {
        super(amount, date);
        this.debitAccountId = debitAccountId;
    }
}
