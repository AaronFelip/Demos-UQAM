package exo5;

class Livre {
    private String titre;
    private String auteur;
    private int nombreDePages;

    public Livre(String titre, String auteur, int nombreDePages) {
        this.titre = titre;
        this.auteur = auteur;
        this.nombreDePages = nombreDePages;
    }

    public String getTitre() {
        return titre;
    }

    public void afficherDetails() {
        System.out.println("Titre: " + titre + ", Auteur: " + auteur + ", Pages: " + nombreDePages);
    }
}