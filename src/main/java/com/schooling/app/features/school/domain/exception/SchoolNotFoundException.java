package com.schooling.app.features.school.domain.exception;

public class SchoolNotFoundException extends RuntimeException{

  public SchoolNotFoundException(String message) {
    super(message);
  }
}
