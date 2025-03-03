package exo6;

import java.util.ArrayList;

class Entreprise {

    private ArrayList< Employe > employes;

    public Entreprise() {

        employes = new ArrayList<>();

    }

    public void ajouterEmploye( Employe employe ) {

        employes.add( employe );
        System.out.println( "Employé ajouté : " + employe.getNom() );

    }

    public void afficherEmployes() {

        System.out.println( "Liste des employés :" );

        for ( Employe employe : employes ) {

            employe.afficherDetails();

        }

    }

}
