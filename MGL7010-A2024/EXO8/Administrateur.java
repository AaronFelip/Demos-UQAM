package exo8;

class Administrateur implements Personne {

    private String nom;

    public Administrateur( String nom ) {

        this.nom = nom;

    }

    public void gererInscription( Etudiant etudiant, String cours ) {

        System.out.println( nom + " gère l'inscription de l'étudiant " + etudiant + " au cours : " + cours );

    }

    @Override
    public void afficherRole() {

        System.out.println( nom + " est un administrateur." );

    }

    @Override
    public String toString() {

        return nom;

    }

}
