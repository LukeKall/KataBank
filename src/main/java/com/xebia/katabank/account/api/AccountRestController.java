package com.xebia.katabank.account.api;

import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.services.AccountService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value ="/account")
public class AccountRestController implements IAccountRestApi {

    @Inject
    AccountService accountService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable(value = "id") String idAccount){
        return accountService.getAccountInformation(idAccount);
    }
}
