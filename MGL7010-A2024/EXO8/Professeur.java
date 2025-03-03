package exo8;

class Professeur implements Personne {

    private String nom;

    public Professeur( String nom ) {

        this.nom = nom;

    }

    public void assignerNote( Etudiant etudiant, String cours, double note ) {

        System.out.println( nom + " a assigné une note de " + note + " à " + etudiant + " pour le cours " + cours );

    }

    @Override
    public void afficherRole() {

        System.out.println( nom + " est un professeur." );

    }

    @Override
    public String toString() {

        return nom;

    }

}
