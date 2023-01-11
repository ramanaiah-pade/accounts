package com.ramana.accounts.payload;

import lombok.Data;

@Data
public class AccountRequest {
    private int customerId;
    private String accountType;
    private String branchAddress;
}
