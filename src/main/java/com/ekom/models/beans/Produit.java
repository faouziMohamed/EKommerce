package com.ekom.models.beans;

import java.util.Objects;

public class Produit {
  private String nom;
  private String id;
  private int qte;
  private double prix;

  public Produit(String nom, String id, int qte, double prix) {
    this.nom = nom;
    this.id = id;
    this.qte = qte;
    this.prix = prix;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNom(), getId(), getQte(), getPrix());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Produit produit = (Produit) o;
    return getQte() == produit.getQte() && Double.compare(produit.getPrix(), getPrix()) == 0 && Objects.equals(getNom(), produit.getNom()) && Objects.equals(getId(), produit.getId());
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getId() {
    return id;
  }

  public int getQte() {
    return qte;
  }

  public void setQte(int qte) {
    this.qte = qte;
  }

  public double getPrix() {
    return prix;
  }

  public void setPrix(double prix) {
    this.prix = prix;
  }

  public void setId(String id) {
    this.id = id;
  }
}
