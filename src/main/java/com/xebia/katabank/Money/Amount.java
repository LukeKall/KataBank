package com.xebia.katabank.Money;

public class Amount {

    private Currency currency;
    private long value;

    public Amount(Currency currency, long value) {
        this.currency = currency;
        this.value = value;
    }

    public boolean isSuperiorThan(Amount amount){
        return this.value > amount.value;
    }

    public void debit(Amount amount){
        this.value -= amount.convertInAnotherCurrency(this.currency).value;
    }

    public Amount convertInAnotherCurrency(Currency currency){
        this.value = this.currency.convertAmountValueInAnotherCurrency(this.value, currency);
        return this;
    }
}
