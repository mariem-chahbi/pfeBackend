package com.creche.crecheapp.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException {

  @Getter
  private ErrorCodes errorCode;
  @Getter
  private List<String> errors;

  public InvalidEntityException(String message, ErrorCodes childNotValid, List<String> errors) {
    super(message);
  }

  public InvalidEntityException(String message, Throwable cause) {
    super(message, cause);
  }

  /*public InvalidEntityException(String message, com.creche.crecheapp.exception.ErrorCodes cause, List<String> errorCode) {
    super(message, cause);
    this.errorCode = errorCode;
  }*/

  public InvalidEntityException(String message, ErrorCodes errorCode) {
    super(message);
    this.errorCode = errorCode;
  }



}
