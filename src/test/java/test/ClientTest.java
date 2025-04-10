package test;

import entite.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    
    private Client clientComplet;
    private Client clientSimple;
    
    @BeforeEach
    public void setUp() {
        clientComplet = new Client(1, "Dupont", "123 Rue des Fleurs", "0612345678", "dupont@email.com") {};
        clientSimple = new Client(2, "Martin");
    }
    
    @Test
    public void testConstructeurComplet() {
        assertEquals(1, clientComplet.getIdClient());
        assertEquals("Dupont", clientComplet.getNom());
        assertEquals("123 Rue des Fleurs", clientComplet.getAdresse());
        assertEquals("0612345678", clientComplet.getTele());
        assertEquals("dupont@email.com", clientComplet.getEmail());
    }
    
    @Test
    public void testConstructeurSimple() {
        assertEquals(2, clientSimple.getIdClient());
        assertEquals("Martin", clientSimple.getNom());
        assertNull(clientSimple.getAdresse());
        assertNull(clientSimple.getTele());
        assertNull(clientSimple.getEmail());
    }
    
    @Test
    public void testSetIdClient() {
        clientComplet.setIdClient(10);
        assertEquals(10, clientComplet.getIdClient());
    }
    
    @Test
    public void testSetNom() {
        clientComplet.setNom("Leblanc");
        assertEquals("Leblanc", clientComplet.getNom());
    }
    
    @Test
    public void testSetAdresse() {
        clientComplet.setAdresse("456 Avenue des Roses");
        assertEquals("456 Avenue des Roses", clientComplet.getAdresse());
    }
    
    @Test
    public void testSetTele() {
        clientComplet.setTele("0698765432");
        assertEquals("0698765432", clientComplet.getTele());
    }
    
    @Test
    public void testSetEmail() {
        clientComplet.setEmail("nouveau@email.com");
        assertEquals("nouveau@email.com", clientComplet.getEmail());
    }
    
  
    @Test
    public void testModificationAttributs() {
        clientSimple.setAdresse("keni grandé");
        clientSimple.setTele("0711223344");
        clientSimple.setEmail("martin@email.com");
        
        assertEquals("keni grandé", clientSimple.getAdresse());
        assertEquals("0711223344", clientSimple.getTele());
        assertEquals("martin@email.com", clientSimple.getEmail());
    }
}