package com.ekom.exception;

public class IncorrectUserException extends Exception {
  public IncorrectUserException() {
    super("Utilisateur incorrect, un objet utilisateur non null est attendu mais 'null' est obtenu");
  }

  public IncorrectUserException(String message) {
    super(message);
  }
}
