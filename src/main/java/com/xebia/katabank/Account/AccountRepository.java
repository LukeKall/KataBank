package com.xebia.katabank.Account;

import com.xebia.katabank.Client.Client;
import com.xebia.katabank.Client.IClientRepository;
import com.xebia.katabank.Money.Amount;
import com.xebia.katabank.Money.Balance;
import com.xebia.katabank.Money.Currency;
import com.xebia.katabank.Money.ICurrencyRepository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;
import java.util.stream.Collectors;

@Named
public class AccountRepository implements IAccountRepository {

    Map<String, Account> allAcounts = new HashMap<>();

    @Inject
    IClientRepository clientRepository;

    @Inject
    ICurrencyRepository currencyRepository;

    public AccountRepository() {
    }

    @PostConstruct
    public void init(){
        Client client = clientRepository.getClientByLogin("pierre-jean");
        Currency currency = currencyRepository.getCurrency("eur");
        Balance balance = new Balance(new Amount(currency, 100), new Date());
        Account account = new Account(client.getId(), "mainAccount", "0112154", balance);
        allAcounts.put(account.getId().toString(), account);
    }

    @Override
    public Account getAccount(String id) {
        return allAcounts.get(id);
    }

    @Override
    public void addAccount(Account account) {
        throw new NotImplementedException();
    }

    @Override
    public void removeAccount(Account account) {
        throw new NotImplementedException();
    }

    @Override
    public void updateAccount(Account account) {
        if(allAcounts.containsKey(account.getId().toString())) {
            allAcounts.put(account.getId().toString(), account);
        }
    }

    @Override
    public List<Account> getAllAcounts() {
        return new ArrayList<>(allAcounts.values());
    }

    @Override
    public List<Account> getAcountsByClient(String clientId) {
        return allAcounts.values().stream().filter(account -> account.isClientPropriety(UUID.fromString(clientId))).collect(Collectors.toList());
    }
}
