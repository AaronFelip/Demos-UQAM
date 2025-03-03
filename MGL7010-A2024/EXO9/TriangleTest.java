package exo9;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void testCalculerAire() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        double s = (3.0 + 4.0 + 5.0) / 2;
        double expectedAire = Math.sqrt(s * (s - 3.0) * (s - 4.0) * (s - 5.0));
        assertEquals(expectedAire, triangle.calculerAire(), 0.0001, "L'aire du triangle n'est pas correcte");
    }

    @Test
    public void testCalculerPerimetre() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        double expectedPerimetre = 3.0 + 4.0 + 5.0;
        assertEquals(expectedPerimetre, triangle.calculerPerimetre(), 0.0001, "Le périmètre du triangle n'est pas correct");
    }
}
