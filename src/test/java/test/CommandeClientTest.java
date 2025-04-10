package test;

import entite.CommandeClient;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CommandeClientTest {

    @Test
    void testConstructeurEtGetters() {
        Date date = new Date();
        CommandeClient commande = new CommandeClient(1, 150.0f, date, 10, "anas");

        assertEquals(1, commande.getIdCommande());
        assertEquals(150.0f, commande.getPrix());
        assertEquals(date, commande.getDateCommande());
        assertEquals(10, commande.getIdClient());
        assertEquals("anas", commande.getNom());
    }

    @Test
    void testSetters() {
        CommandeClient commande = new CommandeClient(0, 0.0f, new Date(), 0, "");

        commande.setIdCommande(2);
        commande.setPrix(200.5f);
        Date nouvelleDate = new Date();
        commande.setDateCommande(nouvelleDate);
        commande.setIdClient(20);
        commande.setNom("simo");

        assertEquals(2, commande.getIdCommande());
        assertEquals(200.5f, commande.getPrix());
        assertEquals(nouvelleDate, commande.getDateCommande());
        assertEquals(20, commande.getIdClient());
        assertEquals("simo", commande.getNom());
    }
}
