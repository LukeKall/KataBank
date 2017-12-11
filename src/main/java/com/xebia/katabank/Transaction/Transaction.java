package com.xebia.katabank.Transaction;

import com.xebia.katabank.Money.Amount;

import java.util.Date;
import java.util.UUID;

public class Transaction {

    private UUID id;
    private Amount amount;
    private Date date;

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }
}
