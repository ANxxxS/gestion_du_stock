package test;

import dao.GérerLesFoumisseursDAO;
import entite.Fournisseur;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GérerLesFoumisseursDAOTest {

    private static int idFournisseurAjouté;

    @Test
    @Order(1)
    public void testAjouterFournisseur() {
        boolean result = GérerLesFoumisseursDAO.ajouterFournisseur("TestFournisseur", "0600000000", "TestAdresse");
        assertTrue(result, "L'ajout du fournisseur doit réussir");
    }

    @Test
    @Order(2)
    public void testGetAllFournisseurs() {
        ArrayList<Fournisseur> fournisseurs = GérerLesFoumisseursDAO.getAll();
        assertNotNull(fournisseurs, "La liste des fournisseurs ne doit pas être nulle");
        assertTrue(fournisseurs.size() > 0, "Il doit y avoir au moins un fournisseur");

        Fournisseur dernier = fournisseurs.get(fournisseurs.size() - 1);
        assertEquals("TestFournisseur", dernier.getNom());
        idFournisseurAjouté = dernier.getIdFournisseur();
    }

    @Test
    @Order(3)
    public void testGetFournisseurs() {
        ArrayList<Fournisseur> fournisseurs = GérerLesFoumisseursDAO.getFournisseurs();
        assertNotNull(fournisseurs);
        assertTrue(fournisseurs.stream().anyMatch(f -> f.getNom().equals("TestFournisseur")));
    }

    @Test
    @Order(4)
    public void testSupprimerFournisseur() {
        boolean result = GérerLesFoumisseursDAO.suprimerFournisseur(idFournisseurAjouté);
        assertTrue(result, "La suppression du fournisseur doit réussir");
    }

    @Test
    @Order(5)
    public void testSupprimerFournisseurInexistant() {
        boolean result = GérerLesFoumisseursDAO.suprimerFournisseur(-1); 
        assertFalse(result, "La suppression d'un fournisseur inexistant doit échouer");
    }
}
