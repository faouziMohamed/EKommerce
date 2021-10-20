package com.ekom.models.products;

import com.ekom.models.beans.Produit;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface IProduitDAO {
  void addProduit(Produit p);

  void removeProduit(String pid);

  void updateOneProduit(String pid, String column, Object changes);

  Produit getProduitById(String pid) throws SQLException;

  ArrayList<Produit> getProduitsByName(String name);
}
