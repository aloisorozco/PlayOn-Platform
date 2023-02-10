package com.playonfantasy.playonfantasyapi.service;

import com.playonfantasy.playonfantasyapi.model.Account;

public interface AccountService {
    public Account saveAccount(Account account);

    public Account updateAccount(Account account);

    public Account getAccount(String email, String password);

    public Account getAccount(String username);

    public int getIdFromUsername(String username);
}
