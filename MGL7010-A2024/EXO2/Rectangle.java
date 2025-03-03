package exo2;

class Rectangle {
    double largeur;
    double hauteur;

    // Constructeur
    public Rectangle(double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    // Méthode pour calculer la surface
    public double calculerSurface() {
        return this.largeur * this.hauteur;
    }

    // Méthode pour calculer le périmètre
    public double calculerPerimetre() {
        return 2 * (this.largeur + this.hauteur);
    }
}
