package com.ergc.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InternalExceptions extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

}