package exo5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BibliothequeTest {

    @Test
    public void testAjouterLivre() {
        Bibliotheque bibliotheque = new Bibliotheque();
        Livre livre = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 96);
        assertDoesNotThrow(() -> bibliotheque.ajouterLivre(livre), "Erreur lors de l'ajout d'un livre");
    }

    @Test
    public void testRechercherLivreTrouve() {
        Bibliotheque bibliotheque = new Bibliotheque();
        Livre livre = new Livre("1984", "George Orwell", 328);
        bibliotheque.ajouterLivre(livre);
        assertDoesNotThrow(() -> bibliotheque.rechercherLivre("1984"), "Le livre '1984' n'a pas été trouvé alors qu'il est dans la bibliothèque");
    }

    @Test
    public void testRechercherLivreNonTrouve() {
        Bibliotheque bibliotheque = new Bibliotheque();
        assertDoesNotThrow(() -> bibliotheque.rechercherLivre("Inconnu"), "Erreur lors de la recherche d'un livre non présent");
    }

    @Test
    public void testAfficherLivres() {
        Bibliotheque bibliotheque = new Bibliotheque();
        Livre livre1 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 96);
        Livre livre2 = new Livre("1984", "George Orwell", 328);
        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);
        assertDoesNotThrow(bibliotheque::afficherLivres, "Erreur lors de l'affichage des livres");
    }
}

