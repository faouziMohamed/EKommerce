package com.ekom.exception;

public class AuthException extends Exception {
  public AuthException() {
    super("Nom d'utilisateur ou mot de pass incorrect");
  }

  public AuthException(String message) {
    super(message);
  }
}
