package com.ramana.accounts.controller;

import com.ramana.accounts.model.Customer;
import com.ramana.accounts.payload.CustomerRequest;
import com.ramana.accounts.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody CustomerRequest request){
        return customerService.saveCustomer(request);
    }
}
