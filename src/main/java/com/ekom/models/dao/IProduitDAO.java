package com.ekom.models.dao;

import com.ekom.models.beans.Produit;

import java.util.ArrayList;
import java.util.Map;

public interface IProduitDAO {
  void addProduit(Produit p);

  boolean removeProduit(String pid);

  boolean updateProduit(String pid, Map<String, String> changes);

  Produit getProduitById(String id);

  ArrayList<Produit> getProduitsByName(String name);
}
