package exo9;

class Triangle implements Forme {
    private double coteA;
    private double coteB;
    private double coteC;

    public Triangle(double coteA, double coteB, double coteC) {
        this.coteA = coteA;
        this.coteB = coteB;
        this.coteC = coteC;
    }

    @Override
    public double calculerAire() {
        double s = (coteA + coteB + coteC) / 2;
        return Math.sqrt(s * (s - coteA) * (s - coteB) * (s - coteC));
    }

    @Override
    public double calculerPerimetre() {
        return coteA + coteB + coteC;
    }
}