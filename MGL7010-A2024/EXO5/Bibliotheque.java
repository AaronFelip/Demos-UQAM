package exo5;

import java.util.ArrayList;


class Bibliotheque {
    private ArrayList<Livre> livres;

    public Bibliotheque() {
        this.livres = new ArrayList<>();
    }

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
        System.out.println("exo5.Livre ajouté : " + livre.getTitre());
    }

    public void rechercherLivre(String titre) {
        for (Livre livre : livres) {
            if (livre.getTitre().equalsIgnoreCase(titre)) {
                System.out.println("exo5.Livre trouvé :");
                livre.afficherDetails();
                return;
            }
        }
        System.out.println("exo5.Livre non trouvé.");
    }

    public void afficherLivres() {
        System.out.println("Livres dans la bibliothèque :");
        for (Livre livre : livres) {
            livre.afficherDetails();
        }
    }
}