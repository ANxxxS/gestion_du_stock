package dao;
import java.util.*;
import entite.Client;
import java.sql.*;

public class GérerLesClientsDAO {
   public static boolean ajouterClient(String nom,String adresse,String tele,String email){
       try {
           PreparedStatement pt = DAO.getInstance().prepareStatement("INSERT INTO `client` ( `nom`, `adresse`, `téléphone`, `email`) VALUES ( ?, ?, ? , ?)");
           pt.setString(1, nom);
           pt.setString(2, adresse);
           pt.setString(3, tele);
           pt.setString(4, email);
           pt.executeUpdate();
           return true;

       } catch (SQLException e) {
            System.out.println(e.getMessage());
           return false;
       }
   }
  public static boolean suprimer(int idClient) {
    try {
        PreparedStatement pt = DAO.getInstance().prepareStatement(
            "DELETE FROM `client` WHERE `idClient` = ?"
        );
        pt.setInt(1, idClient);
        int lignesModifiées = pt.executeUpdate();
        return lignesModifiées > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

  public static  ArrayList<Client> getAll(){
      try {
          PreparedStatement pt = DAO.getInstance().prepareStatement("SELECT * FROM `client`");
          ArrayList<Client> tab =new ArrayList();
          ResultSet rs = pt.executeQuery();
          while(rs.next()){
              tab.add(new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
          }
          return tab;
      } catch (SQLException e) {
          
            System.out.println(e.getMessage());
            return null;
            
      }
  }
  public static ArrayList<Client> getClient() {
    ArrayList<Client> tab = new ArrayList<>();
    try {
        PreparedStatement pt = DAO.getInstance().prepareStatement("SELECT * FROM client");
        ResultSet rs = pt.executeQuery();
        
        while (rs.next()) {
            Client c = new Client(rs.getInt("idClient"), rs.getString("nom"));
            System.out.println("Ajout du client : " + c.getNom());
            tab.add(c);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tab;
}

 
}
