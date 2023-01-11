package com.ramana.accounts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GenericGenerator(name = "customer_id", strategy = "com.ramana.accounts.util.CustomerIdGenerator")
    @GeneratedValue(generator = "customer_id")
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile_number")
    private Long mobileNumber;
    @Column(name = "created_date")
    private LocalDate createdDate;

    public Customer(String name, String email, Long mobileNumber, LocalDate createdDate) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.createdDate = createdDate;
    }
}
