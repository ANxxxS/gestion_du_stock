package entite;

import java.util.Date;


public class CommandeFournisseurs {
     private int idCommande;
    private float prix;
    private Date dateCommande;
    private int idFournisseurs;
    private String nom;

    public CommandeFournisseurs(int idCommande, float prix, Date dateCommande, int idFournisseurs, String nom) {
        this.idCommande = idCommande;
        this.prix = prix;
        this.dateCommande = dateCommande;
        this.idFournisseurs = idFournisseurs;
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

    public int getIdFournisseurs() {
        return idFournisseurs;
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

    public void setIdFournisseurs(int idFournisseurs) {
        this.idFournisseurs = idFournisseurs;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

  
    
}
