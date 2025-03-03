package exo8;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AdministrateurTest {

    @Test
    public void testGererInscription() {
        Administrateur admin = new Administrateur("Mme. Martin");
        Etudiant etudiant = new Etudiant("Alice");
        // Test de la gestion d'inscription
        assertDoesNotThrow(() -> admin.gererInscription(etudiant, "Mathématiques"), "Erreur lors de la gestion de l'inscription");
    }

    @Test
    public void testAfficherRole() {
        Administrateur admin = new Administrateur("Mme. Martin");
        // On ne peut pas tester directement l'affichage sur la console, mais on vérifie que la méthode existe et fonctionne.
        assertDoesNotThrow(admin::afficherRole, "Erreur lors de l'affichage du rôle");
    }

    @Test
    public void testToString() {
        Administrateur admin = new Administrateur("Mme. Martin");
        assertEquals("Mme. Martin", admin.toString(), "Le toString ne retourne pas le bon nom");
    }
}