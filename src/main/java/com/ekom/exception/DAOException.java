package com.ekom.exception;

public class DAOException extends Exception{
  public DAOException() {
    this("Une erreur est survenu lors de l'opération");
  }

  public DAOException(String message) {
    super(message);
  }
}
