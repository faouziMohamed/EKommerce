package com.ekom.exception;

public class ParamMissingException extends Exception {
  public ParamMissingException() {
    super("Un paramètre est attendu mais rien n'a été passé");
  }

  public ParamMissingException(String message) {
    super(message);
  }
}
