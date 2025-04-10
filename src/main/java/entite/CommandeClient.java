package entite;

import java.util.Date;

public class CommandeClient {

    private int idCommande;
    private float prix;
    private Date dateCommande;
    private int idClient;
    private String nom;

    public CommandeClient(int idCommande, float prix, Date dateCommande, int idClient, String nom) {
        this.idCommande = idCommande;
        this.prix = prix;
        this.dateCommande = dateCommande;
        this.idClient = idClient;
        this.nom = nom;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public float getPrix() {
        return prix;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   

}
