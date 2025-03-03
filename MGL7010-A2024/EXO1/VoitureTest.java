
package exo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VoitureTest {

    @Test
    public void testCreationVoiture() {
        Voiture voiture = new Voiture("Toyota", "Rouge", 180);
        assertEquals("Toyota", voiture.marque, "La marque de la voiture n'est pas correcte");
        assertEquals("Rouge", voiture.couleur, "La couleur de la voiture n'est pas correcte");
        assertEquals(180, voiture.vitesseMax, "La vitesse maximale de la voiture n'est pas correcte");
    }

    @Test
    public void testAfficherDetails() {
        Voiture voiture = new Voiture("Toyota", "Rouge", 180);
        assertDoesNotThrow(voiture::afficherDetails, "Erreur lors de l'affichage des détails de la voiture");
    }
}
