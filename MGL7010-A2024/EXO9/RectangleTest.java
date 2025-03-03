package exo9;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    @Test
    public void testCalculerAire() {
        Rectangle rectangle = new Rectangle(4.0, 7.0);
        double expectedAire = 4.0 * 7.0;
        assertEquals(expectedAire, rectangle.calculerAire(), 0.0001, "L'aire du rectangle n'est pas correcte");
    }

    @Test
    public void testCalculerPerimetre() {
        Rectangle rectangle = new Rectangle(4.0, 7.0);
        double expectedPerimetre = 2 * (4.0 + 7.0);
        assertEquals(expectedPerimetre, rectangle.calculerPerimetre(), 0.0001, "Le périmètre du rectangle n'est pas correct");
    }
}
