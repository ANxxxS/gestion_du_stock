package test;


import entite.Fournisseur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FournisseurTest {
    
    private Fournisseur fournisseur1;
    private Fournisseur fournisseur2;
    
    @BeforeEach
    public void setUp() {
        fournisseur1 = new Fournisseur(1, "Alami SARL", "contact@alami.ma", "123 Avenue Hassan II, Casablanca");
        fournisseur2 = new Fournisseur(2, "Benani & Fils");
    }
    
    @Test
    public void testConstructeurComplet() {
        assertEquals(1, fournisseur1.getIdFournisseur());
        assertEquals("Alami SARL", fournisseur1.getNom());
        assertEquals("contact@alami.ma", fournisseur1.getContact());
        assertEquals("123 Avenue Hassan II, Casablanca", fournisseur1.getAdresse());
    }
    
    @Test
    public void testConstructeurPartiel() {
        assertEquals(2, fournisseur2.getIdFournisseur());
        assertEquals("Benani & Fils", fournisseur2.getNom());
        assertNull(fournisseur2.getContact());
        assertNull(fournisseur2.getAdresse());
    }
    
    @Test
    public void testSetIdFournisseur() {
        fournisseur1.setIdFournisseur(3);
        assertEquals(3, fournisseur1.getIdFournisseur());
    }
    
    @Test
    public void testSetNom() {
        fournisseur1.setNom("Alami Import-Export");
        assertEquals("Alami Import-Export", fournisseur1.getNom());
    }
    
    @Test
    public void testSetContact() {
        fournisseur2.setContact("info@benani.ma");
        assertEquals("info@benani.ma", fournisseur2.getContact());
    }
    
    @Test
    public void testSetAdresse() {
        fournisseur2.setAdresse("45 Rue Mohammed V, Rabat");
        assertEquals("45 Rue Mohammed V, Rabat", fournisseur2.getAdresse());
    }
}