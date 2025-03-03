package exo6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EntrepriseTest {

    @Test
    public void testAjouterEmploye() {
        Entreprise entreprise = new Entreprise();
        Employe employe = new Employe("Jean Dupont", 2500);
        assertDoesNotThrow(() -> entreprise.ajouterEmploye(employe), "Erreur lors de l'ajout d'un employé");
    }

    @Test
    public void testAfficherEmployes() {
        Entreprise entreprise = new Entreprise();
        Employe employe1 = new Employe("Jean Dupont", 2500);
        Employe employe2 = new Employe("Marie Curie", 3000);
        entreprise.ajouterEmploye(employe1);
        entreprise.ajouterEmploye(employe2);
        assertDoesNotThrow(entreprise::afficherEmployes, "Erreur lors de l'affichage des employés");
    }
}

