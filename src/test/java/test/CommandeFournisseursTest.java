package test;


import entite.CommandeFournisseurs;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class CommandeFournisseursTest {

    @Test
    void testConstructeurEtGettersAvecFournisseur() {
        Date dateAid = new GregorianCalendar(2024, 3, 10).getTime(); 

        CommandeFournisseurs commande = new CommandeFournisseurs(
                501,                 
                1500.0f,             
                dateAid,             
                1001,                
                "Ateliers Yassir"    
        );

        assertEquals(501, commande.getIdCommande());
        assertEquals(1500.0f, commande.getPrix());
        assertEquals(dateAid, commande.getDateCommande());
        assertEquals(1001, commande.getIdFournisseurs());
        assertEquals("Ateliers Yassir", commande.getNom());
    }

    @Test
    void testSettersAvecFournisseur() {
        CommandeFournisseurs commande = new CommandeFournisseurs(0, 0.0f, new Date(), 0, "");

        Date dateRamadan = new GregorianCalendar(2024, 2, 15).getTime();

        commande.setIdCommande(502);
        commande.setPrix(3200.50f);
        commande.setDateCommande(dateRamadan);
        commande.setIdFournisseurs(2002);
        commande.setNom("Coopérative Al Baraka"); 

        assertEquals(502, commande.getIdCommande());
        assertEquals(3200.50f, commande.getPrix());
        assertEquals(dateRamadan, commande.getDateCommande());
        assertEquals(2002, commande.getIdFournisseurs());
        assertEquals("Coopérative Al Baraka", commande.getNom());
    }
}
