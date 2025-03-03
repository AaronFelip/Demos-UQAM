package exo4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CompteBancaireTest {

    @Test
    public void testDepot() {
        CompteBancaire compte = new CompteBancaire("Alice", 1000);
        compte.deposer(500);
        assertEquals(1500, compte.getSolde(), 0.0001, "Le solde après dépôt est incorrect");
    }

    @Test
    public void testRetrait() {
        CompteBancaire compte = new CompteBancaire("Alice", 1000);
        compte.retirer(300);
        assertEquals(700, compte.getSolde(), 0.0001, "Le solde après retrait est incorrect");
    }

    @Test
    public void testRetraitSoldeInsuffisant() {
        CompteBancaire compte = new CompteBancaire("Alice", 1000);
        compte.retirer(2000);  // Solde insuffisant
        assertEquals(1000, compte.getSolde(), 0.0001, "Le solde ne doit pas changer si le retrait est impossible");
    }

    @Test
    public void testAfficherSolde() {
        CompteBancaire compte = new CompteBancaire("Alice", 1000);
        assertDoesNotThrow(compte::afficherSolde, "Erreur lors de l'affichage du solde");
    }
}

