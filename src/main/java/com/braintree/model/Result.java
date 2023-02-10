package com.braintree.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Result<T> {
    private T object;
    private boolean success;
    private String message;

}
