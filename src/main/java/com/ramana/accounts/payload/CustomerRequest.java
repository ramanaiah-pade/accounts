package com.ramana.accounts.payload;

import lombok.Data;

@Data
public class CustomerRequest {
    private String name;
    private String email;
    private Long mobileNumber;
}
