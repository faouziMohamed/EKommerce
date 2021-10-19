package com.ekom.models.dao;

import com.ekom.models.beans.Produit;

import java.util.ArrayList;

public interface IProduitDAO {
  boolean addProduit(Produit p);

  Produit getProduitById(String id);

  ArrayList<Produit> getProduitsByName(String name);
}
