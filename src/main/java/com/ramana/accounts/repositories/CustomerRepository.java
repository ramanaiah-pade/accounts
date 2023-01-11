package com.ramana.accounts.repositories;


import com.ramana.accounts.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
