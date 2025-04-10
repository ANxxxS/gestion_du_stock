package entite;


public class Client {
    private int idClient;
    private String nom;
    private String adresse;
    private String tele;
    private String email;

    public Client(int idClient, String nom, String adresse, String tele, String email) {
        this.idClient = idClient;
        this.nom = nom;
        this.adresse = adresse;
        this.tele = tele;
        this.email = email;
    }

    public Client(int idClient, String nom) {
        this.idClient = idClient;
        this.nom = nom;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTele() {
        return tele;
    }

    public String getEmail() {
        return email;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     @Override
    public String toString() {
        return this.nom;
    }
    
}
    