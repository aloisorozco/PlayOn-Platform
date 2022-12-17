package com.playonfantasy.playonplatform.controller;

import com.playonfantasy.playonplatform.model.Account;
import com.playonfantasy.playonplatform.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * There is an error with login; infinite loop for account.teams and team.account
     * Check https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
     * For @JsonManagedReference and @JsonBackReference
     */
    @PostMapping("/verifyLogin")
    public ResponseEntity<Account> verifyLogin(@RequestBody Account account) {
        //not sure if do with account or another model class with just email and password fields
        Account a;
        try{
            a = accountService.getAccount(account.getEmail(),account.getPassword());
            return new ResponseEntity<>(a, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody Account account) {
        //not sure if do with account or another model class?
        accountService.saveAccount(account);
        return "Account " + account.getEmail() + " has been created";
    }

    @PutMapping("/update")
    public String updateAccount(@RequestBody Account account) {
        try{
            accountService.updateAccount(account);
        }
        catch (Exception e) {
            return "Error while updating account: " + e.getMessage();
        }

        return "Account " + account.getEmail() + " has been updated";
    }
}
