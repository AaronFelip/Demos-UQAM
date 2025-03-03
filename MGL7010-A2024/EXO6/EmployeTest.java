package exo6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmployeTest {

    @Test
    public void testAugmenterSalaire() {
        Employe employe = new Employe("Jean Dupont", 2500);
        employe.augmenterSalaire(10);
        assertEquals(2750, employe.getSalaire(), 0.0001, "Le salaire après augmentation est incorrect");
    }

    @Test
    public void testAugmenterSalairePourcentageInvalide() {
        Employe employe = new Employe("Jean Dupont", 2500);
        employe.augmenterSalaire(-5);  // Pourcentage invalide
        assertEquals(2500, employe.getSalaire(), 0.0001, "Le salaire ne doit pas changer si le pourcentage est invalide");
    }

    @Test
    public void testAfficherDetails() {
        Employe employe = new Employe("Jean Dupont", 2500);
        assertDoesNotThrow(employe::afficherDetails, "Erreur lors de l'affichage des détails de l'employé");
    }

    @Test
    public void testGetNom() {
        Employe employe = new Employe("Jean Dupont", 2500);
        assertEquals("Jean Dupont", employe.getNom(), "Le nom de l'employé n'est pas correct");
    }
}
