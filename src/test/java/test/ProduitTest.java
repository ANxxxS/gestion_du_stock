package test;

import entite.Produit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ProduitTest {
    
    private Produit produit1;
    private Produit produit2;
    private Produit produit3;
    
    @BeforeEach
    public void setUp() {
        produit1 = new Produit(1, "Huile d'argan", 150.0f);
        produit2 = new Produit(3, "Cosmétiques");
        produit3 = new Produit(2, "Tajine en terre cuite", "Tajine traditionnel fait à la main", 250.0f, 50, 3, "Cosmétiques");
    }
    
    @Test
    public void testConstructeurPartiel1() {
        assertEquals(1, produit1.getIdProduit());
        assertEquals("Huile d'argan", produit1.getNomProduit());
        assertEquals(150.0f, produit1.getPrix(), 0.001);
        assertNull(produit1.getDescription());
        assertEquals(0, produit1.getQuantiteEnStock());
        assertEquals(0, produit1.getIdCategorie());
        assertNull(produit1.getNomCategorie());
    }
    
    @Test
    public void testConstructeurPartiel2() {
        assertEquals(0, produit2.getIdProduit());
        assertNull(produit2.getNomProduit());
        assertEquals(0.0f, produit2.getPrix(), 0.001);
        assertNull(produit2.getDescription());
        assertEquals(0, produit2.getQuantiteEnStock());
        assertEquals(3, produit2.getIdCategorie());
        assertEquals("Cosmétiques", produit2.getNomCategorie());
    }
    
    @Test
    public void testConstructeurComplet() {
        assertEquals(2, produit3.getIdProduit());
        assertEquals("Tajine en terre cuite", produit3.getNomProduit());
        assertEquals("Tajine traditionnel fait à la main", produit3.getDescription());
        assertEquals(250.0f, produit3.getPrix(), 0.001);
        assertEquals(50, produit3.getQuantiteEnStock());
        assertEquals(3, produit3.getIdCategorie());
        assertEquals("Cosmétiques", produit3.getNomCategorie());
    }
    
    @Test
    public void testSetIdProduit() {
        produit1.setIdProduit(10);
        assertEquals(10, produit1.getIdProduit());
    }
    
    @Test
    public void testSetNomProduit() {
        produit1.setNomProduit("Huile d'argan bio");
        assertEquals("Huile d'argan bio", produit1.getNomProduit());
    }
    
    @Test
    public void testSetDescription() {
        produit1.setDescription("Huile naturelle du Maroc");
        assertEquals("Huile naturelle du Maroc", produit1.getDescription());
    }
    
    @Test
    public void testSetPrix() {
        produit1.setPrix(175.5f);
        assertEquals(175.5f, produit1.getPrix(), 0.001);
    }
    
    @Test
    public void testSetQuantiteEnStock() {
        produit1.setQuantiteEnStock(100);
        assertEquals(100, produit1.getQuantiteEnStock());
    }
    
    @Test
    public void testSetIdCategorie() {
        produit1.setIdCategorie(2);
        assertEquals(2, produit1.getIdCategorie());
    }
    
    @Test
    public void testSetNomCategorie() {
        produit1.setNomCategorie("Produits naturels");
        assertEquals("Produits naturels", produit1.getNomCategorie());
    }
}