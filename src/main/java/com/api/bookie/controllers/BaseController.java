package com.api.bookie.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.api.bookie.commons.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseController {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Response> handleValidationException(MethodArgumentNotValidException except) {
    Map<String, String> errors = new HashMap<>();
    except.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    var _response = new Response();
    _response.setErrors(errors);
    _response.setDateTime(new Date(System.currentTimeMillis()));
    _response.setCode(400);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(_response);
  }

}
