package exo8;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EtudiantTest {

    @Test
    public void testInscrireCours() {
        Etudiant etudiant = new Etudiant("Alice");
        assertDoesNotThrow(() -> etudiant.inscrireCours("Mathématiques"), "Erreur lors de l'inscription au cours");
    }

    @Test
    public void testAfficherRole() {
        Etudiant etudiant = new Etudiant("Alice");
        assertDoesNotThrow(etudiant::afficherRole, "Erreur lors de l'affichage du rôle");
    }

    @Test
    public void testToString() {
        Etudiant etudiant = new Etudiant("Alice");
        assertEquals("Alice", etudiant.toString(), "Le toString ne retourne pas le bon nom");
    }
}
