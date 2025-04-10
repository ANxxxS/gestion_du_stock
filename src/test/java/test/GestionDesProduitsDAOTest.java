package test;

import dao.GestionDesProduitsDAO;
import entite.Produit;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GestionDesProduitsDAOTest {

    @Test
    public void testGetAll_RetourneProduits() throws ClassNotFoundException {
        ArrayList<Produit> produits = GestionDesProduitsDAO.getAll();
        
        assertNotNull(produits, "La liste des produits ne devrait pas être null");
        assertFalse(produits.isEmpty(), "La liste des produits ne devrait pas être vide");
        
        Produit premierProduit = produits.get(0);
        assertNotNull(premierProduit.getIdProduit());
        assertNotNull(premierProduit.getNomProduit());
        assertNotNull(premierProduit.getDescription());
        assertNotNull(premierProduit.getPrix());
        assertNotNull(premierProduit.getQuantiteEnStock());
        assertNotNull(premierProduit.getIdCategorie());
        assertNotNull(premierProduit.getNomCategorie());
    }

    @Test
    public void testGetByCat_RetourneProduitsCategorie() throws ClassNotFoundException {
        String categorieTest = "Moteurs"; 
        ArrayList<Produit> produits = GestionDesProduitsDAO.getByCat(categorieTest);
        
        assertNotNull(produits);
        for (Produit p : produits) {
            assertEquals(categorieTest, p.getNomCategorie());
        }
    }

    @Test
    public void testGetCategorie_RetourneCategories() throws ClassNotFoundException {
        ArrayList<Produit> categories = GestionDesProduitsDAO.getCategorie();
        
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        for (Produit p : categories) {
            assertNotNull(p.getNomCategorie());
        }
    }

    @Test
    public void testAjouterProduit_Success() throws ClassNotFoundException {
        boolean result = GestionDesProduitsDAO.ajouterProduit(
            "Nouveau Produit", 
            "Description test", 
            100.0f, 
            10, 
            1 
        );
        assertTrue(result);
    }

    @Test
    public void testModifierProduit_Success() throws ClassNotFoundException {
        boolean result = GestionDesProduitsDAO.ModifierProduit(
            2, 
            "Produit Modifié", 
            "Nouvelle description", 
            150.0f, 
            5, 
            2 
        );
        assertTrue(result);
    }

    @Test
    public void testSuprimerProduit_Success() throws ClassNotFoundException {
        GestionDesProduitsDAO.ajouterProduit("Produit à supprimer", "Test", 50.0f, 5, 1);
        
        ArrayList<Produit> produits = GestionDesProduitsDAO.getAll();
        int dernierId = produits.get(produits.size()-1).getIdProduit();
        
        boolean result = GestionDesProduitsDAO.suprimerProduit(dernierId);
        assertTrue(result);
    }
}