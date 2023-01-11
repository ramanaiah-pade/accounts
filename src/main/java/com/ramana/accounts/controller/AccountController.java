package com.ramana.accounts.controller;

import com.ramana.accounts.exceptions.NotFoundException;
import com.ramana.accounts.model.Account;
import com.ramana.accounts.model.Customer;
import com.ramana.accounts.payload.AccountRequest;
import com.ramana.accounts.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/myAccount/{customerId}")
    public Account getAccountDetails(@PathVariable int customerId){
        Optional<Account> account = accountService.findByCustomerId(customerId);
        if(account .isEmpty())
            throw new NotFoundException("There is no matching account for give customer id: " + customerId);
        return account.get();
    }

    @PostMapping("/createAccount")
    public Account createNewAccount(@RequestBody AccountRequest request){
        Account account = accountService.createAccount(request);
        return account;
    }

}
