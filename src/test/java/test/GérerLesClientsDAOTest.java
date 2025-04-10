package test;

import dao.GérerLesClientsDAO;
import entite.Client;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GérerLesClientsDAOTest {

    private static int idClientAjouté;

    @Test
    @Order(1)
    public void testAjouterClient() {
        boolean result = GérerLesClientsDAO.ajouterClient("ahmad", "Paris", "0123456789", "ahmad@mail.com");
        assertTrue(result, "L'ajout du client doit réussir");
    }

    @Test
    @Order(2)
    public void testGetAllClients() {
        ArrayList<Client> clients = GérerLesClientsDAO.getAll();
        assertNotNull(clients, "La liste des clients ne doit pas être null");
        assertTrue(clients.size() > 0, "Il doit y avoir au moins un client");

        Client dernierClient = clients.get(clients.size() - 1);
        assertEquals("ahmad", dernierClient.getNom());
        idClientAjouté = dernierClient.getIdClient();
    }

    @Test
    @Order(3)
    public void testGetClient() {
        ArrayList<Client> clients = GérerLesClientsDAO.getClient();
        assertNotNull(clients, "La liste filtrée des clients ne doit pas être null");
        assertTrue(clients.stream().anyMatch(c -> c.getNom().equals("ahmad")), "Le client Jean doit exister");
    }

    @Test
    @Order(4)
    public void testSupprimerClient() {
        boolean result = GérerLesClientsDAO.suprimer(idClientAjouté);
        assertTrue(result, "La suppression du client doit réussir");
    }

    @Test
    @Order(5)
    public void testSupprimerClientInexistant() {
        boolean result = GérerLesClientsDAO.suprimer(-1); 
        assertFalse(result, "La suppression d'un client inexistant doit échouer");
    }
}
