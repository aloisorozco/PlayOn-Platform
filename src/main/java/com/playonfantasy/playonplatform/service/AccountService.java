package com.playonfantasy.playonplatform.service;

import com.playonfantasy.playonplatform.model.Account;

public interface AccountService {
    public Account saveAccount(Account account);

    public Account updateAccount(Account account);

    public Account getAccount(String email, String password);

    public Account getAccount(String username);

    public int getIdFromUsername(String username);
}
