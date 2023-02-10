package com.braintree.controller;


import com.braintree.model.*;
import com.braintree.service.BrainTreeServices;
import com.braintreegateway.*;
import com.braintreegateway.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BraintreeController {

    @Autowired
    private BrainTreeServices brainTreeServices;

    @RequestMapping(value = "/checkouts", method = RequestMethod.GET)
    public ResponseEntity<Map<String, String>> checkout() {
        return brainTreeServices.checkout();
    }
    @PostMapping("/submit")
    public Result<Transaction> submitPayment(@RequestBody PaymentRequest paymentRequest) {
        return brainTreeServices.submitPayment(paymentRequest);
    }

    @PostMapping("/submit/googlepay")
    public Result<Transaction> submitGooglePay(@RequestBody GooglePayRequest googlePayRequest) {
        return brainTreeServices.submitGooglePay(googlePayRequest);
    }

    @PostMapping("/submit/applepay")
    public Result<Transaction> submitApplePay(@RequestBody ApplePayRequest applePayRequest) {
        return brainTreeServices.submitApplePay(applePayRequest);
    }

    @PostMapping("/submit/paypal")
    public Result<Transaction> submitPaypal(@RequestBody PaypalRequest paypalRequest) {
        return brainTreeServices.submitPaypal(paypalRequest);
    }
}



