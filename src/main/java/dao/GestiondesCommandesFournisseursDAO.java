package dao;

import java.sql.*;
import entite.*;
import java.text.*;
import java.util.*;

public class GestiondesCommandesFournisseursDAO {
     public static boolean ajouterCMDFournisseurs(int idFournisseur, int IDprouduit, int quantiter, float prix) throws ParseException, SQLException, ClassNotFoundException {
    try {
        boolean res = false;
        
        String sql = "INSERT INTO `commande` ( `dateCommande`, `idFournisseur`, `idClient`) VALUES ( ?, ?, NULL)";
        PreparedStatement pt = DAO.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        pt.setDate(1, sqlDate);
        pt.setInt(2, idFournisseur);
     
        int rowsInserted = pt.executeUpdate();
        
        if (rowsInserted == 0) {
            System.err.println("l'ajoute du commande du Fournisseur a échoué, aucune ligne n'a été insérée.");
        }
        
        try (ResultSet generatedKeys = pt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idComande = generatedKeys.getInt(1);
                float prix_totale = prix * quantiter;
              
                String sqlL = "INSERT INTO `lignecommande` (`idCommande`, `idProduit`, `quantite`, `prix`) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = DAO.getInstance().prepareStatement(sqlL);
                ps.setInt(1, idComande);
                ps.setInt(2, IDprouduit);
                ps.setInt(3, quantiter);
                ps.setFloat(4, prix_totale);
                ps.executeUpdate();
                res = true;
            } else {
                System.err.println("l'ajoute du commande du Fournisseur a échoué, aucun ID n'a été retourné.");
            }
        }
        return res;
    } catch (Exception e) {
        return false;
    }
}
     public static ArrayList<CommandeFournisseurs> getAll(){
         try {
             ArrayList<CommandeFournisseurs> tab = new ArrayList();
             String sql ="SELECT lignecommande.idCommande,   lignecommande.prix, commande.dateCommande,  commande.idFournisseur,  fournisseur.nom FROM lignecommande INNER JOIN commande ON lignecommande.idCommande = commande.idCommande INNER JOIN fournisseur ON commande.idFournisseur = fournisseur.idFournisseur";
             PreparedStatement pt = DAO.getInstance().prepareStatement(sql);
             ResultSet rs = pt.executeQuery();
             while(rs.next()){
                 tab.add(new CommandeFournisseurs(
                 rs.getInt(1),
                         rs.getFloat(2),
                               rs.getDate(3),
                                       rs.getInt(4),
                                             rs.getString(5)
                 ));
             }
             return tab;
         } catch (Exception e) {
             return null;
         }
     }
   
}
