package exo9;

class Rectangle implements Forme {
    private double largeur;
    private double hauteur;

    public Rectangle(double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public double calculerAire() {
        return largeur * hauteur;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * (largeur + hauteur);
    }
}