package com.ramana.accounts.services;

import com.ramana.accounts.model.Customer;
import com.ramana.accounts.payload.CustomerRequest;
import com.ramana.accounts.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(CustomerRequest request){
        Customer customer = new Customer(request.getName(), request.getEmail(), request.getMobileNumber(), LocalDate.now());
        return customerRepository.save(customer);
    }

    public Optional<Customer> findByCustomerId(int customerId){
        return customerRepository.findById(customerId);
    }
}
