package com.xebia.katabank.transaction.entities;

import com.xebia.katabank.money.entities.Amount;

import java.util.Date;
import java.util.UUID;

/**
 * Représente une transaction bancaire
 */
public class Transaction {

    private UUID id;
    private Amount amount;
    private Date date;

    public Transaction(Amount amount, Date date) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }
}
