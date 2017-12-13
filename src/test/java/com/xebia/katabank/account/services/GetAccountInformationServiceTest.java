package com.xebia.katabank.account.services;

import com.xebia.katabank.extension.MockitoExtension;
import com.xebia.katabank.account.entities.Account;
import com.xebia.katabank.account.entities.Balance;
import com.xebia.katabank.account.repository.IAccountRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests de la classe GetAccountInformationService
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class GetAccountInformationServiceTest {

    @Mock
    IAccountRepository accountRepository;

    @InjectMocks
    GetAccountInformationService getAccountInformationService;

    @Test
    public void getAccountInformation(){
        Account account = new Account(UUID.randomUUID(), "account", "number", Mockito.mock(Balance.class));
        Mockito.when(accountRepository.getAccount(account.getId().toString())).thenReturn(account);
        assertEquals(account, getAccountInformationService.getAccountInformation(account.getId().toString()));
    }
}
