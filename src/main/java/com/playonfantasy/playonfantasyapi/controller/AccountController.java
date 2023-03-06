package com.playonfantasy.playonfantasyapi.controller;

import com.playonfantasy.playonfantasyapi.model.Account;
import com.playonfantasy.playonfantasyapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /** FIXED
     * There is an error with login; infinite loop for account.teams and team.account
     * Check https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
     * For @JsonManagedReference and @JsonBackReference
     */
    /**
     * Login
     * @param account
     * @return TODO should return a JWT Token
     */
    @PostMapping("/login")
    public ResponseEntity<Integer> login(@RequestBody Account account) {
        Account a;
        try{
            a = accountService.getAccount(account.getEmail(),account.getPassword());


            //TODO: return AccountResponse model object instead
            //or JWT Token idk
            return new ResponseEntity<>(a.getId(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Register
     * @param account
     * @return TODO: return nothing?
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Account account) {
        //TODO: handle duplicate acc
        Account a = accountService.saveAccount(account);
        if (a != null) {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    /**
     * Update account
     * @param account
     * @return TODO: MsgModel
     */
    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody Account account) {
        try{
            accountService.updateAccount(account);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error while updating account: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Account " + account.getEmail() + " has been updated", HttpStatus.OK);
    }
}
