package exo9;

public class Main {
    public static void main(String[] args) {
        Forme cercle = new Cercle(5.0);
        Forme rectangle = new Rectangle(4.0, 7.0);
        Forme triangle = new Triangle(3.0, 4.0, 5.0);

        System.out.println("Cercle - Aire: " + cercle.calculerAire() + ", Périmètre: " + cercle.calculerPerimetre());
        System.out.println("Rectangle - Aire: " + rectangle.calculerAire() + ", Périmètre: " + rectangle.calculerPerimetre());
        System.out.println("Triangle - Aire: " + triangle.calculerAire() + ", Périmètre: " + triangle.calculerPerimetre());
    }
}