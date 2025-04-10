package entite;


public class Fournisseur {
    private int idFournisseur;
    private String nom;
    private String contact;
    private String adresse;

    public Fournisseur(int idFournisseur, String nom, String contact, String adresse) {
        this.idFournisseur = idFournisseur;
        this.nom = nom;
        this.contact = contact;
        this.adresse = adresse;
    }

    public Fournisseur(int idFournisseur, String nom) {
        this.idFournisseur = idFournisseur;
        this.nom = nom;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public String getNom() {
        return nom;
    }

    public String getContact() {
        return contact;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    
}
