package fr.madenspacher.menupizza.classes;

public class Pizza {
    private String nom;
    private int prix;
    private int nbIngredients;

    public Pizza(String nom, int prix, int nbIngredients) {
        this.nom = nom;
        this.prix = prix;
        this.nbIngredients = nbIngredients;
    }

    public int getNbIngredients() {
        return nbIngredients;
    }

    public void setNbIngredients(int nbIngredients) {
        this.nbIngredients = nbIngredients;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", nbIngredients=" + nbIngredients +
                '}';
    }

}
