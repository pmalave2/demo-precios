package com.example.demo.precios.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = PriceNotFoundDomainException.MESSAGE)
public class PriceNotFoundDomainException extends RuntimeException {
  public static final String MESSAGE = "Price Not Found";

  public PriceNotFoundDomainException() {
    super(MESSAGE);
  }
}
