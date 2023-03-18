package com.bankingmanagement.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {
    private String errorMessage;
    private String requestedURI;
}
