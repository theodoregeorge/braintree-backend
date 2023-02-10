package com.braintree.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class PaymentRequest {
    private String paymentMethodNonce;
    private BigDecimal amount;
}
