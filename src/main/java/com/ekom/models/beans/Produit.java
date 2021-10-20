package com.ekom.models.beans;

import com.ekom.utils.Utils;

import java.util.Objects;

public class Produit {
  private String id;
  private String nom;
  private int qte;
  private double prix;
  private String urlImage;

  public Produit(String nom, int qte, double prix, String urlImage) {
    this.nom = nom;
    this.qte = qte;
    this.prix = prix;
    this.urlImage = urlImage;
    this.id = Utils.generateIdFromObj(this);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
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

  public String getUrlImage() {
    return urlImage;
  }

  public void setUrlImage(String urlImage) {
    this.urlImage = urlImage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Produit produit = (Produit) o;
    return getQte() == produit.getQte() && Double.compare(produit.getPrix(), getPrix()) == 0 && getId().equals(produit.getId()) && getNom().equals(produit.getNom()) && getUrlImage().equals(produit.getUrlImage());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNom(), getQte(), getPrix(), getUrlImage());
  }
}
