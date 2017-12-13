package com.xebia.katabank.money.entities;

/**
 * Représente un montant d'une monnaie
 */
public class Amount {

    private Currency currency;
    private long value;

    public Amount() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        if (value != amount.value) return false;
        return currency != null ? currency.equals(amount.currency) : amount.currency == null;
    }

    @Override
    public int hashCode() {
        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (int) (value ^ (value >>> 32));
        return result;
    }
}
