package exo8;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProfesseurTest {

    @Test
    public void testAssignerNote() {
        Professeur professeur = new Professeur("Dr. Smith");
        Etudiant etudiant = new Etudiant("Alice");
        assertDoesNotThrow(() -> professeur.assignerNote(etudiant, "Mathématiques", 18.5), "Erreur lors de l'assignation de la note");
    }

    @Test
    public void testAfficherRole() {
        Professeur professeur = new Professeur("Dr. Smith");
        assertDoesNotThrow(professeur::afficherRole, "Erreur lors de l'affichage du rôle");
    }

    @Test
    public void testToString() {
        Professeur professeur = new Professeur("Dr. Smith");
        assertEquals("Dr. Smith", professeur.toString(), "Le toString ne retourne pas le bon nom");
    }
}

