package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/user_id={id}")
    List<Account> getAccountByUserId(@PathVariable(value = "id") int id) {
        return accountService.getAccountByUserId(id);
    }

    @GetMapping("/{nr}")
    Account getAccountByNumber(@PathVariable(value = "nr") Long nr) {
        return accountService.getAccountByNumber(nr);
    }

    @PostMapping(consumes = "application/json")
    void addAccount(@RequestBody Account account) {
        accountService.addAccount(account);
    }

    @DeleteMapping("/{nr}")
    void deleteAccountByNumber(@PathVariable(value = "nr") Long nr) {
        accountService.deleteAccountByNumber(nr);
    }
}
