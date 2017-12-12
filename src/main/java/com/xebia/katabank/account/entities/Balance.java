package com.xebia.katabank.account.entities;

import com.xebia.katabank.money.entities.Amount;
import com.xebia.katabank.account.error.BalanceUnsuffisantException;

import java.util.Date;

/**
 * Représente un solde
 */
public class Balance {

    private Amount amount;
    private Date lastUpdate;

    public Balance(Amount amount, Date lastUpdate) {
        this.amount = amount;
        this.lastUpdate = lastUpdate;
    }

    /**
     * Vérifie si la balance est suffisante pour faire un débit
     * @param amount
     * @return
     */
    public boolean isBalanceSuffisantForDebit(Amount amount) {
        return this.amount.isSuperiorThan(amount);
    }

    /**
     * Débite le solde à une date donnée
     * @param amount
     * @param dateDebit
     */
    public void debit(Amount amount, Date dateDebit) throws BalanceUnsuffisantException {
        if(!isBalanceSuffisantForDebit(amount)){
            throw new BalanceUnsuffisantException();
        }
        this.amount.debit(amount);
        this.lastUpdate = dateDebit;
    }
}
