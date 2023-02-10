package com.braintree.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PaymentResponse {
    private boolean success;
    private String transactionId;


}
