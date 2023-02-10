package com.braintree.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class GooglePayRequest {
    private BigDecimal amount;
    private String paymentMethodNonce;

}