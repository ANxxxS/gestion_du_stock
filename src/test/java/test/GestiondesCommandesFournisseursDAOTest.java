package test;

import dao.GestiondesCommandesFournisseursDAO;
import entite.CommandeFournisseurs;
import org.junit.jupiter.api.*;
import java.sql.Date;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GestiondesCommandesFournisseursDAOTest {
    @BeforeAll
    public static void setUpBeforeClass() {
       
    }
    @BeforeEach
    public void setUp() {
       
    }

    @Test
    public void testAjouterCMDFournisseurs_Success() {
        try {
            boolean result = GestiondesCommandesFournisseursDAO.ajouterCMDFournisseurs(4, 2, 3, 10.5f);
            assertTrue(result);
        } catch (Exception e) {
            fail("Exception non attendue: " + e.getMessage());
        }
    }

    @Test
    public void testAjouterCMDFournisseurs_FournisseurInexistant() {
        try {
            boolean result = GestiondesCommandesFournisseursDAO.ajouterCMDFournisseurs(999, 2, 3, 10.5f);
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception non attendue: " + e.getMessage());
        }
    }

    @Test
    public void testGetAll_RetourneCommandes() {
        ArrayList<CommandeFournisseurs> commandes = GestiondesCommandesFournisseursDAO.getAll();
        
        assertNotNull(commandes, "La liste des commandes ne devrait pas être null");
        assertFalse(commandes.isEmpty(), "La liste des commandes ne devrait pas être vide");
        
        CommandeFournisseurs premiereCommande = commandes.get(0);
        assertNotNull(premiereCommande.getIdCommande());
        assertNotNull(premiereCommande.getPrix());
        assertNotNull(premiereCommande.getDateCommande());
        assertNotNull(premiereCommande.getIdFournisseurs());
        assertNotNull(premiereCommande.getNom());
    }

    @Test
    public void testGetAll_FormatDonneesCorrect() {
        ArrayList<CommandeFournisseurs> commandes = GestiondesCommandesFournisseursDAO.getAll();
        
        for (CommandeFournisseurs cmd : commandes) {
            assertTrue(cmd.getIdCommande() > 0);
            assertTrue(cmd.getPrix() >= 0);
            assertTrue(cmd.getIdFournisseurs() > 0);
            assertFalse(cmd.getNom().isEmpty());
        }
    }
    @AfterEach
    public void tearDown() {
       
    }
    @AfterAll
    public static void tearDownAfterClass() {
    
    }
}