package com.xebia.katabank.Money;

import java.util.Date;

public class Balance {

    private Amount amount;
    private Date lastUpdate;

    public Balance(Amount amount, Date lastUpdate) {
        this.amount = amount;
        this.lastUpdate = lastUpdate;
    }

    public boolean isBalanceSuffisant(Amount amount) {
        return this.amount.isSuperiorThan(amount);
    }

    public void debit(Amount amount, Date dateDebit){
        this.amount.debit(amount);
        this.lastUpdate = dateDebit;
    }
}
