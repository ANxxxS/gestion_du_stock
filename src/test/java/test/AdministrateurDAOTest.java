package test;



import dao.AdministrateurDAO;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AdministrateurDAOTest {

    @Test
    public void testConnexionValide() throws Exception {
        String email = "admin@gmail.com";
        String motDePasse = "12345678";

        boolean resultat = AdministrateurDAO.getConnexion(email, motDePasse);
        assertTrue(resultat, " connexion  réussir");
    }

    @Test
    public void testConnexionInvalide() throws Exception {
        String email = "inexistant@example.com";
        String motDePasse = "mauvaispass";

        boolean resultat = AdministrateurDAO.getConnexion(email, motDePasse);
        assertFalse(resultat, " connexion  échouer ");
    }
}

