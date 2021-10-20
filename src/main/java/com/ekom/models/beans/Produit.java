package com.ekom.models.beans;

import com.ekom.utils.Utils;

import java.util.Objects;

public class Produit {
  private String id;
  private String nom;
  private int qte;
  private double prix;
  private String urlImage;
  private String description;

  public Produit(String id, String nom, int qte, double prix, String urlImage, String description) {
    this.nom = nom;
    this.qte = qte;
    this.prix = prix;
    this.urlImage = urlImage;
    this.description = description;
    if (id == null) {
      this.id = Utils.generateIdFromObj(this);
    } else {
      this.id = id;
    }
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
    return getQte() == produit.getQte() &&
      Double.compare(produit.getPrix(), getPrix()) == 0 &&
      getId().equals(produit.getId()) &&
      getNom().equals(produit.getNom()) &&
      getUrlImage().equals(produit.getUrlImage()) &&
      Objects.equals(getDescription(), produit.getDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getNom(), getQte(), getPrix(), getUrlImage(), getDescription());
  }
}
