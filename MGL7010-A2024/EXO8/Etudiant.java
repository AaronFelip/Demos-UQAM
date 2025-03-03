package exo8;

import java.util.ArrayList;

class Etudiant implements Personne {

    private String nom;
    private ArrayList< String > cours;

    public Etudiant( String nom ) {

        this.nom = nom;
        this.cours = new ArrayList<>();

    }

    public void inscrireCours( String cours ) {

        this.cours.add( cours );
        System.out.println( nom + " s'est inscrit au cours : " + cours );

    }

    @Override
    public void afficherRole() {

        System.out.println( nom + " est un étudiant." );

    }

    @Override
    public String toString() {

        return nom;

    }

}
