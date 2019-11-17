package com.intercorp.retail.maincustomer.expose.advicer;

import com.intercorp.retail.maincustomer.exception.CustomerException;
import com.intercorp.retail.maincustomer.expose.advicer.model.CustomerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<CustomerErrorResponse> customerHandleNotFound(Exception ex) {
        CustomerErrorResponse errors = new CustomerErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

}
