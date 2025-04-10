package dao;

import entite.Fournisseur;
import java.sql.*;
import java.util.*;

public class GérerLesFoumisseursDAO {

    public static boolean ajouterFournisseur(String nom, String contact, String adresse) {
        try {
            PreparedStatement pt = DAO.getInstance().prepareStatement("INSERT INTO `fournisseur` ( `nom`, `contact`, `adresse`) VALUES ( ?, ?, ?)");
            pt.setString(1, nom);
            pt.setString(2, contact);
            pt.setString(3, adresse);
            pt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
 
   public static boolean suprimerFournisseur(int id) {
    try {
        PreparedStatement pt = DAO.getInstance().prepareStatement("DELETE FROM `fournisseur` WHERE idFournisseur = ?");
        pt.setInt(1, id);
        int rows = pt.executeUpdate();
        return rows > 0;
    } catch (Exception e) {
        return false;
    }
}


   public static ArrayList<Fournisseur> getAll(){
       try {
           PreparedStatement pt = DAO.getInstance().prepareStatement("SELECT * FROM `fournisseur`");
           ArrayList<Fournisseur> tab = new ArrayList();
           ResultSet rs = pt.executeQuery();
           while(rs.next()){
               tab.add(new Fournisseur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
           }
           return tab;
       } catch (SQLException e) {
           return null;
       }
   }
   public static ArrayList<Fournisseur> getFournisseurs(){
       try {
           PreparedStatement pt = DAO.getInstance().prepareStatement("SELECT * FROM `fournisseur`");
           ArrayList<Fournisseur> tab = new ArrayList();
           ResultSet rs = pt.executeQuery();
           while(rs.next()){
               tab.add(new Fournisseur(rs.getInt(1),rs.getString(2)));
           }
           return tab;
       } catch (SQLException e) {
           return null;
       }
   }
   
   
}
