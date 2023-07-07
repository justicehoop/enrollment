package com.naver.jpa.enrollment.exception;

public class ResourceNotFoundException extends RuntimeException{

  public ResourceNotFoundException(String msg) {
    super(msg);
  }

  public ResourceNotFoundException(String msg, Throwable t) {
    super(msg, t);
  }
}
