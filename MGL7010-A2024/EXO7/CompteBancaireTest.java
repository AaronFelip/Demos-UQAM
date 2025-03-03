package exo7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CompteBancaireTest {

    @Test
    public void testDepotCompteCourant() {
        CompteCourant compte = new CompteCourant("Alice", 1000);
        compte.deposer(500);
        assertEquals(1500, compte.solde, "Le solde du compte courant après dépôt est incorrect");
    }

    @Test
    public void testRetraitCompteCourant() {
        CompteCourant compte = new CompteCourant("Alice", 1000);
        compte.retirer(300);
        assertEquals(700, compte.solde, "Le solde du compte courant après retrait est incorrect");
    }

    @Test
    public void testRetraitCompteEntreprise() {
        CompteEntreprise compte = new CompteEntreprise("Bob", 2000);
        compte.retirer(400);  // Il y a des frais de 5 EUR
        assertEquals(1595, compte.solde, "Le solde du compte entreprise après retrait est incorrect");
    }

    @Test
    public void testRetraitCompteEpargne() {
        CompteEpargne compte = new CompteEpargne("Charlie", 1500);
        compte.retirer(200);  // Le retrait doit laisser au moins 100 EUR
        assertEquals(1300, compte.solde, "Le solde du compte épargne après retrait est incorrect");
    }
}

