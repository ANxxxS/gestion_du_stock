package dao;

import java.util.*;
import java.sql.*;
import entite.Produit;


public class GestionDesProduitsDAO {

    public static ArrayList<Produit> getAll()throws 
             ClassNotFoundException {
        try {
        
             PreparedStatement pt = DAO.getInstance().prepareStatement("SELECT p.* ,c.nom FROM `produit` p INNER JOIN `categorie` c ON p.idCategorie=c.idCategorie;");
             ResultSet rs = pt.executeQuery();
             ArrayList<Produit> tabProduit = new ArrayList();
             while(rs.next()){
                  
                 tabProduit.add(new Produit(
                 rs.getInt(1),
                         rs.getString(2),
                         rs.getString(3),
                         rs.getFloat(4),
                         rs.getInt(5),
                         rs.getInt(6),
                          rs.getString(7)
                        
                 ));
             }
             return tabProduit;
        } catch (SQLException e) {
            return null;
        }
    }
     public static ArrayList<Produit> getByCat(String cat)throws 
             ClassNotFoundException {
        try {
        
             PreparedStatement pt = DAO.getInstance().prepareStatement("SELECT p.* ,c.nom FROM `produit` p INNER JOIN `categorie` c ON p.idCategorie=c.idCategorie WHERE LOWER(c.`nom`) LIKE LOWER(?) ;");
             pt.setString(1, cat +'%');
             ResultSet rs = pt.executeQuery();
             ArrayList<Produit> tabProduit = new ArrayList();
             while(rs.next()){
                  
                 tabProduit.add(new Produit(
                 rs.getInt(1),
                         rs.getString(2),
                         rs.getString(3),
                         rs.getFloat(4),
                         rs.getInt(5),
                         rs.getInt(6),
                          rs.getString(7)
                        
                 ));
             }
             return tabProduit;
        } catch (SQLException e) {
            return null;
        }
    }
     public static ArrayList<Produit> getCategorie() throws ClassNotFoundException{
         try {
                          PreparedStatement pt = DAO.getInstance().prepareStatement("SELECT * FROM categorie");
                          ResultSet rs = pt.executeQuery();
             ArrayList<Produit> tabProduit = new ArrayList();
             while(rs.next()){
                  
                 tabProduit.add(new Produit(
                 rs.getInt(1),
                         rs.getString(2)      
                 ));
             }
             return tabProduit;
         } catch (SQLException e) {
             return null;
         }
     }
     public static ArrayList<Produit> getProduit() throws ClassNotFoundException{
         try {
              PreparedStatement pt = DAO.getInstance().prepareStatement("SELECT * FROM produit");
                          ResultSet rs = pt.executeQuery();
             ArrayList<Produit> tabProduit = new ArrayList();
             while(rs.next()){
                  
                 tabProduit.add(new Produit(
                 rs.getInt(1),
                         rs.getString(2),
                          rs.getFloat(4)
                 ));
             }
             return tabProduit;
         } catch (SQLException e) {
                 return null;
         }
   
     }
     
     public static boolean ajouterProduit(String nom,String description,float prix ,int qt,int idCat) throws ClassNotFoundException{
         try {
            PreparedStatement pt = DAO.getInstance().prepareStatement("INSERT INTO `produit` (`idProduit`, `nom`, `description`, `prix`, `quantiteEnStock`, `idCategorie`) VALUES (NULL, ? , ?, ?, ?, ?)");
            pt.setString(1,nom);
            pt.setString(2,description);
            pt.setFloat(3, prix);
            pt.setInt(4, qt);
            pt.setInt(5, idCat);
            pt.executeUpdate();
return true;         } catch (SQLException e) {
             System.out.println(e.getMessage());
             return false;
         }
     }
     public static boolean ModifierProduit(int idProduit,String nom,String description,float prix ,int qt,int idCat) throws ClassNotFoundException{
         try {
    PreparedStatement pt = DAO.getInstance().prepareStatement("UPDATE `produit` SET  `nom`= ?, `description` = ?, `prix` = ?, `quantiteEnStock` = ?, `idCategorie` = ? WHERE `idProduit` = ?");
     pt.setString(1,nom);
            pt.setString(2,description);
            pt.setFloat(3, prix);
            pt.setInt(4, qt);
            pt.setInt(5, idCat);
            pt.setInt(6, idProduit);
            pt.executeUpdate();
         return true;  
         } catch (SQLException e) {
            System.out.println(e.getMessage());        return false;
         }
     }
     
     public static boolean suprimerProduit(int idProduit) throws ClassNotFoundException{
         try {
             PreparedStatement pt = DAO.getInstance().prepareStatement("DELETE FROM `produit` WHERE `idProduit` = ? ");
             pt.setInt(1, idProduit);
             pt.executeUpdate();
                 return true;  
         } catch (SQLException e) {
          System.out.println(e.getMessage()); return false;

         }
     }
     
  
}
