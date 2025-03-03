package exo2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    @Test
    public void testCalculerSurface() {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        double expectedSurface = 5.0 * 3.0;
        assertEquals(expectedSurface, rectangle.calculerSurface(), 0.0001, "La surface du rectangle est incorrecte");
    }

    @Test
    public void testCalculerPerimetre() {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        double expectedPerimetre = 2 * (5.0 + 3.0);
        assertEquals(expectedPerimetre, rectangle.calculerPerimetre(), 0.0001, "Le périmètre du rectangle est incorrect");
    }
}

