package exo3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ChienTest {

    @Test
    public void testCreationChien() {
        Chien chien = new Chien("Rex");
        assertEquals("Rex", chien.nom, "Le nom du chien n'est pas correct");
    }

    @Test
    public void testParler() {
        Chien chien = new Chien("Rex");
        assertDoesNotThrow(chien::parler, "Erreur lors de l'appel de la méthode parler pour le chien");
    }
}

