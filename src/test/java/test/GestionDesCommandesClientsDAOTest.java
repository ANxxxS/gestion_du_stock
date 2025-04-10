package test;

import dao.GestionDesCommandesClientsDAO;
import entite.CommandeClient;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GestionDesCommandesClientsDAOTest {

    @Test
    public void testAjouterCMDclient_Reussi() throws Exception {
        int idClient = 5;
        int idProduit = 2;
        int quantite = 2;
        float prixUnitaire = 10.5f;

        boolean resultat = GestionDesCommandesClientsDAO.ajouterCMDclient(idClient, idProduit, quantite, prixUnitaire);
        assertTrue(resultat, "L'ajout de la commande réussir");
    }

    @Test
    public void testAjouterCMDclient_EchecClientInexistant() throws Exception {
        int idClientInexistant = 9999;
        int idProduit = 1;
        int quantite = 1;
        float prixUnitaire = 10.0f;

        boolean resultat = GestionDesCommandesClientsDAO.ajouterCMDclient(idClientInexistant, idProduit, quantite, prixUnitaire);
        assertFalse(resultat, "L'ajout  échouer avec un client inexistant");
    }

    @Test
    public void testGetAll_RetourneCommandes() {
        ArrayList<CommandeClient> commandes = GestionDesCommandesClientsDAO.getAll();
        
        assertNotNull(commandes, "La liste des commandes not null");
        assertFalse(commandes.isEmpty(), "La liste des commandes not vide");
        
        CommandeClient premiereCommande = commandes.get(0);
        assertNotNull(premiereCommande.getIdCommande());
        assertNotNull(premiereCommande.getPrix());
        assertNotNull(premiereCommande.getDateCommande());
        assertNotNull(premiereCommande.getIdClient());
        assertNotNull(premiereCommande.getNom());
    }

    @Test
    public void testGetAll_FormatDonneesCorrect() {
        ArrayList<CommandeClient> commandes = GestionDesCommandesClientsDAO.getAll();
        
        for (CommandeClient cmd : commandes) {
            assertTrue(cmd.getIdCommande() > 0);
            assertTrue(cmd.getPrix() >= 0);
            assertTrue(cmd.getIdClient() > 0);
            assertFalse(cmd.getNom().isEmpty());
        }
    }
}