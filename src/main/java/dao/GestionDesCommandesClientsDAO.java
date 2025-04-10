package dao;

import java.sql.*;
import entite.*;
import java.text.*;
import java.util.*;


public class GestionDesCommandesClientsDAO {
  public static boolean ajouterCMDclient(int idClient, int IDprouduit, int quantiter, float prix) {
    try {
        boolean res = false;

        Connection conn = DAO.getInstance();
        String sql = "INSERT INTO `commande` ( `dateCommande`, `idFournisseur`, `idClient`) VALUES ( ?, NULL, ?)";
        PreparedStatement pt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        pt.setDate(1, sqlDate);
        pt.setInt(2, idClient);

        int rowsInserted = pt.executeUpdate();

        if (rowsInserted == 0) {
            System.err.println("L'ajout de la commande a échoué.");
        }

        try (ResultSet generatedKeys = pt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idCommande = generatedKeys.getInt(1);
                float prixTotal = prix * quantiter;

                String sqlL = "INSERT INTO `lignecommande` (`idCommande`, `idProduit`, `quantite`, `prix`) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sqlL);
                ps.setInt(1, idCommande);
                ps.setInt(2, IDprouduit);
                ps.setInt(3, quantiter);
                ps.setFloat(4, prixTotal);

                ps.executeUpdate();
                res = true;
            } else {
                System.err.println("Aucun ID de commande généré.");
            }
        }

        return res;
    } catch (Exception e) {
        e.printStackTrace(); 
        return false;
    }
}

   public static ArrayList<CommandeClient> getAll(){
       try {
           String sql ="SELECT lignecommande.idCommande,   lignecommande.prix, commande.dateCommande,  commande.idClient,  client.nom FROM lignecommande INNER JOIN commande ON lignecommande.idCommande = commande.idCommande INNER JOIN client ON commande.idClient = client.idClient";
           PreparedStatement pt =DAO.getInstance().prepareStatement(sql);
           ResultSet rs = pt.executeQuery();
           ArrayList tab = new ArrayList();
           while(rs.next()){
               tab.add(new
         CommandeClient(rs.getInt(1),rs.getFloat(2),rs.getDate(3),rs.getInt(4),rs.getString(5)));
           }
           return tab;
       } catch (Exception e) {
                   e.printStackTrace(); 

           return null;
       }
   }
           
       
   
        
      
}
