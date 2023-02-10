package com.playonfantasy.playonfantasyapi.service;

import com.playonfantasy.playonfantasyapi.model.Account;
import com.playonfantasy.playonfantasyapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public Account saveAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        Account a = accountRepo.findById(account.getId()).get();

        a.setPassword(account.getPassword());

        return accountRepo.save(a);
    }

    public int getIdFromUsername(String username) {
        return accountRepo.getIdByUsername(username);
    }

    @Override
    public Account getAccount(String email, String password) {
        return accountRepo.findByEmailAndPassword(email, password);
    }

    @Override
    public Account getAccount(String username) {
        return accountRepo.findByUsername(username);
    }
}
