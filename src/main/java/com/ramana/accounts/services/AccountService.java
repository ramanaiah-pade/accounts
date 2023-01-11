package com.ramana.accounts.services;

import com.ramana.accounts.exceptions.BadRequestException;
import com.ramana.accounts.exceptions.NotFoundException;
import com.ramana.accounts.model.Account;
import com.ramana.accounts.model.Customer;
import com.ramana.accounts.payload.AccountRequest;
import com.ramana.accounts.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Optional<Account> findByCustomerId(int customerId) {
        Optional<Account> account = accountRepository.findByCustomerId(customerId);
        return account;
    }

    public Account createAccount(AccountRequest request) {
        Account account = new Account(request.getCustomerId(), request.getAccountType(), request.getBranchAddress(), LocalDate.now());
        Optional<Account> isAccountExist = this.findAccountByCustomerId(request.getCustomerId());
        if(isAccountExist.isPresent())
            throw new BadRequestException("Already this customer have Bank Account.");

        account = accountRepository.save(account);
        return account;
    }

    public Optional<Account> findAccountByCustomerId(int customerId){
        return accountRepository.findByCustomerId(customerId);
    }
}
