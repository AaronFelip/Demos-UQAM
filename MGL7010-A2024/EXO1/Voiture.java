package exo1;

class Voiture {
    String marque;
    String couleur;
    int vitesseMax;

    // Constructeur
    public Voiture(String marque, String couleur, int vitesseMax) {
        this.marque = marque;
        this.couleur = couleur;
        this.vitesseMax = vitesseMax;
    }

    // Méthode pour afficher les détails de la voiture
    public void afficherDetails() {
        System.out.println("Marque: " + this.marque);
        System.out.println("Couleur: " + this.couleur);
        System.out.println("Vitesse Maximale: " + this.vitesseMax + " km/h");
    }
}


