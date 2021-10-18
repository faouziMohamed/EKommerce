package com.ekom.exception;

public class NoUserConnectedException extends Exception {

  public NoUserConnectedException() {
    super("Vous devez vous connecter pour suivre ce chemin");
  }

  public NoUserConnectedException(String message) {
    super(message);
  }
}
