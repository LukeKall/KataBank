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

    public Transaction(String id, Amount amount, Date date) {
        this.id = UUID.fromString(id);
        this.amount = amount;
        this.date = date;
    }

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

    public Amount getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
