package com.xebia.katabank.money.entities;

/**
 * Représente un montant d'une monnaie
 */
public class Amount {

    private Currency currency;
    private long value;


    public Amount(Currency currency, long value) {
        this.currency = currency;
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    /**
     * Test si le montant est supérieur à un autre
     * @param amount
     * @return
     */
    public boolean isSuperiorThan(Amount amount){
        return this.value > amount.convertInAnotherCurrency(this.currency).value;
    }

    /**
     * Débite un montant
     * @param amount
     */
    public void debit(Amount amount){
        this.value -= amount.convertInAnotherCurrency(this.currency).value;
    }

    /**
     * Convertit le montant en une autre monnaie
     * @param currency
     * @return
     */
    public Amount convertInAnotherCurrency(Currency currency){
        this.value = this.currency.convertAmountValueInAnotherCurrency(this.value, currency);
        this.currency = currency;
        return this;
    }
}
