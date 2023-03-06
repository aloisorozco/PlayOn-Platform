package com.playonfantasy.playonfantasyapi.service;

import com.playonfantasy.playonfantasyapi.model.Account;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.UUID;

public interface AccountService {
    public Account saveAccount(Account account);

    public Account updateAccount(Account account);

    public Account getAccount(String email, String password);

//    public Account getAccount(String username);

    public Account getAccount(int id) throws ChangeSetPersister.NotFoundException;

//    public int getIdFromUsername(String username);
}
