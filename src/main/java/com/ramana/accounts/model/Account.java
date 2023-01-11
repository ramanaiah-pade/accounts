package com.ramana.accounts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @Column(name = "account_number")
    @GenericGenerator(name = "acc_no", strategy = "com.ramana.accounts.util.AccountNumberGenerator")
    @GeneratedValue(generator = "acc_no")
    private long accountNumber;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "branch_address")
    private String branchAddress;
    @Column(name = "create_date")
    private LocalDate createDate;

    public Account(int customerId, String accountType, String branchAddress, LocalDate createDate) {
        this.customerId = customerId;
        this.accountType = accountType;
        this.branchAddress = branchAddress;
        this.createDate = createDate;
    }
}
