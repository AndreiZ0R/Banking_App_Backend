package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository acccountRepo;

    @Autowired
    public AccountService(AccountRepository accountRepo) {
        this.acccountRepo = accountRepo;
    }

    public List<Account> getAllAccounts() {
        return acccountRepo.getAllAccounts();
    }

    public List<Account> getAccountByUserId(int id) {
        return acccountRepo.getAccountByUserId(id);
    }

    public Account getAccountByNumber(Long nr) {
        return acccountRepo.getAccountByNumber(nr);
    }

    public void addAccount(Account account) {
        acccountRepo.addAccount(account.getNrcont(), account.getSold(), account.getIdpers());
    }

    public void deleteAccountByNumber(Long nr) {
        acccountRepo.deleteAccountByNumber(nr);
    }

}
