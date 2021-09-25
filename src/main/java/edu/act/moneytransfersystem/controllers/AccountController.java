package edu.act.moneytransfersystem.controllers;

import edu.act.moneytransfersystem.domains.Account;
import edu.act.moneytransfersystem.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    // for creating /inserting Account to the DB
    // call service class
    @PostMapping("/api/account/create")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);

    }
    // list all account that have been created by user

    @GetMapping("/api/account/list")
    public Iterable<Account> listAccounts(){
        return accountService.allAccounts();

    }
}
