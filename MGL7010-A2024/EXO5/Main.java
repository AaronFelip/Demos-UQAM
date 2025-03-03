package exo5;

public class Main {
    public static void main(String[] args) {

        Bibliotheque maBibliotheque = new Bibliotheque();

        Livre livre1 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 96);
        Livre livre2 = new Livre("1984", "George Orwell", 328);

        maBibliotheque.ajouterLivre(livre1);
        maBibliotheque.ajouterLivre(livre2);

        maBibliotheque.afficherLivres();

        maBibliotheque.rechercherLivre("1984");
        maBibliotheque.rechercherLivre("Inconnu");

    }

}
