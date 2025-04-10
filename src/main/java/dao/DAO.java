package dao;
import java.sql.*;

public class DAO {
    private static Connection con = null;
    private static DAO db = null;
    
    private DAO() {
        connect();
    }
    
   
    private boolean connect() {
        try {
            if (con != null && !con.isClosed() && con.isValid(5)) {
                return true;
            }
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gestion_stock?autoReconnect=true", 
                "root", 
                ""
            );
            
            if (con != null) {
                System.out.println("Connexion à la base de données établie avec succès");
                return true;
            }
            return false;
            
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur: Driver MySQL introuvable");
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            System.err.println("Erreur SQL lors de la connexion à la base de données");
            e.printStackTrace();
            return false;
        }
    }
    
   
    public static Connection getInstance() {
        try {
            if (db == null) {
                db = new DAO();
            }
            
            if (con == null || con.isClosed() || !con.isValid(2)) {
                db.connect();
                
                if (con == null || con.isClosed()) {
                    System.err.println("Échec de reconnexion à la base de données");
                    return null;
                }
            }
            
            return con;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la vérification ou récupération de la connexion");
            e.printStackTrace();
            
            if (db.connect()) {
                return con;
            }
            return null;
        }
    }
 
    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Connexion à la base de données fermée");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la fermeture de la connexion");
            e.printStackTrace();
        }
    }
    
  
    public static boolean testConnection() {
        try {
            Connection testCon = getInstance();
            return testCon != null && !testCon.isClosed() && testCon.isValid(2);
        } catch (SQLException e) {
            System.err.println("Erreur lors du test de connexion");
            e.printStackTrace();
            return false;
        }
    }
}