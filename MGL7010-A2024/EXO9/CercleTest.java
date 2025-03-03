package exo9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CercleTest {

    @Test
    public void testCalculerAire() {
        Cercle cercle = new Cercle(5.0);
        double expectedAire = Math.PI * 5.0 * 5.0;
        assertEquals(expectedAire, cercle.calculerAire(), 0.0001, "L'aire du cercle n'est pas correcte");
    }

    @Test
    public void testCalculerPerimetre() {
        Cercle cercle = new Cercle(5.0);
        double expectedPerimetre = 2 * Math.PI * 5.0;
        assertEquals(expectedPerimetre, cercle.calculerPerimetre(), 0.0001, "Le périmètre du cercle n'est pas correct");
    }
}
