package com.ekom.exception;

public class UserNotFoundException extends Exception {
  public UserNotFoundException() {
    super("Utilisateur non trouvé");
  }
}
