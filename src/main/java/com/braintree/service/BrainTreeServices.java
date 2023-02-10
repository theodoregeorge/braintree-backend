package com.braintree.service;

import com.braintree.model.*;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface BrainTreeServices {
    com.braintreegateway.Result<Transaction> submitGooglePay(GooglePayRequest googlePayRequest);
    com.braintreegateway.Result<Transaction> submitApplePay(ApplePayRequest applePayRequest);
    com.braintreegateway.Result<Transaction> submitPaypal(PaypalRequest paypalRequest);
    Result<Transaction> submitPayment(PaymentRequest paymentRequest);
    ResponseEntity<Map<String, String>> checkout();
}
