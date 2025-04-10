package entite;


public class Produit {
    
private int idProduit;
private String nomProduit;
private String description;
private float prix;
private int quantiteEnStock;
private int idCategorie;
private String nomCategorie;

    public Produit(int idProduit, String nomProduit, float prix) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prix=prix;
    }
  public Produit(int idCategorie, String nomCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
       
    }


    public Produit(int idProduit, String nomProduit, String description, float prix, int quantiteEnStock, int idCategorie, String nomCategorie) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.description = description;
        this.prix = prix;
        this.quantiteEnStock = quantiteEnStock;
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public String getDescription() {
        return description;
    }

    public float getPrix() {
        return prix;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

  

   
    
   

   
}
