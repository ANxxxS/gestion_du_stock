package dao;


import entite.Produit;
import java.sql.*;
import view.Login;


public class AdministrateurDAO {
  
    public static boolean getConnexion(String email, String motDePasse) throws ClassNotFoundException{
                    boolean isValide = false ;

        try {
                    String sqlAdmin = "SELECT * FROM `utilisateur` WHERE email = ? AND motDePasse = ?";
                    PreparedStatement pt  = DAO.getInstance().prepareStatement(sqlAdmin);
                    pt.setString(1, email);
                    pt.setString(2, motDePasse);
                    ResultSet rs = pt.executeQuery();
                  isValide = rs.next();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return isValide;
    }

   
}
