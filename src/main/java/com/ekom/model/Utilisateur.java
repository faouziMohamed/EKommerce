package com.ekom.model;

import java.util.Objects;

public class Utilisateur {
  private String nom;
  private String prenom;
  private String email;
  private String password;

  public Utilisateur(String nom, String prenom, String email, String password) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.password = password;
  }

  public String getNom() {
    return nom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Utilisateur that = (Utilisateur) o;
    return Objects.equals(getNom(), that.getNom()) && Objects.equals(getPrenom(), that.getPrenom()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNom(), getPrenom(), getEmail(), getPassword());
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
