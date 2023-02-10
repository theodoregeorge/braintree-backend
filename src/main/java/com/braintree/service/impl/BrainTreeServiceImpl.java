package com.braintree.service.impl;

import com.braintree.model.*;
import com.braintree.service.BrainTreeServices;
import com.braintreegateway.*;
import com.braintreegateway.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BrainTreeServiceImpl implements BrainTreeServices {


    private static BraintreeGateway gateway = new BraintreeGateway(
            Environment.SANDBOX,
            "r9sznyzmvcxw4v29",
            "fg9cxm8txddy38n9",
            "5fbd6aade0ef69eff3b4e3ff0f0a4c26"
    );

    @Override
    public com.braintreegateway.Result<Transaction> submitGooglePay(GooglePayRequest googlePayRequest) {
        TransactionRequest request = new TransactionRequest()
                .amount(googlePayRequest.getAmount())
                .paymentMethodNonce(googlePayRequest.getPaymentMethodNonce())
                .options()
                .submitForSettlement(true)
                .done();

        com.braintreegateway.Result<Transaction> result = gateway.transaction().sale(request);

        if (result.isSuccess()) {
            return result;
        } else {
            // Transaction failed
            ValidationErrors errors = result.getErrors();
            for (ValidationError error : errors.getAllValidationErrors()) {
                if (error.getCode().equals("81715")) {
                    // Card number is invalid

                } else if (error.getCode().equals("81716")) {
                    // CVV is invalid

                } else if (error.getCode().equals("81721")) {
                    // Expired card

                } else {
                    // Other error
                    System.out.println(error.getMessage());
                }
            }
            return result;
        }
    }

    @Override
    public com.braintreegateway.Result<Transaction> submitApplePay(ApplePayRequest applePayRequest) {
        TransactionRequest request = new TransactionRequest()
                .amount(applePayRequest.getAmount())
                .paymentMethodNonce(applePayRequest.getPaymentMethodNonce())
                .options()
                .submitForSettlement(true)
                .done();

        com.braintreegateway.Result<Transaction> result = gateway.transaction().sale(request);

        if (result.isSuccess())
        {
            return result;
        } else {
            return result;
        }
    }

    @Override
    public com.braintreegateway.Result<Transaction> submitPaypal(PaypalRequest paypalRequest) {
        TransactionRequest request = new TransactionRequest()
                .amount(paypalRequest.getAmount())
                .paymentMethodNonce(paypalRequest.getPaymentMethodNonce())
                .options()
                .submitForSettlement(true)
                .done();

        com.braintreegateway.Result<Transaction> result = gateway.transaction().sale(request);

        if (result.isSuccess()) {
            return result;
        } else {
            return result;
        }
    }

    @Override
    public Result<Transaction> submitPayment(PaymentRequest paymentRequest) {
        TransactionRequest request = new TransactionRequest()
                .amount(paymentRequest.getAmount())
                .paymentMethodNonce(paymentRequest.getPaymentMethodNonce())
                .options()
                .submitForSettlement(true)
                .done();

        com.braintreegateway.Result<Transaction> result = gateway.transaction().sale(request);

        if (result.isSuccess()) {
            return result;
        } else {
            return result;
        }
    }

    @Override
    public ResponseEntity<Map<String, String>> checkout() {
        String clientToken = gateway.clientToken().generate();
        Map<String, String> response = new HashMap<>();
        response.put("clientToken", clientToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
