package exo9;

class Cercle implements Forme {
    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public double calculerAire() {
        return Math.PI * rayon * rayon;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * Math.PI * rayon;
    }
}