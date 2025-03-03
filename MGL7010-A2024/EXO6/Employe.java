package exo6;

class Employe {

    private String nom;
    private double salaire;

    public Employe( String nom, double salaire ) {

        this.nom = nom;
        this.salaire = salaire;

    }

    public void augmenterSalaire( double pourcentage ) {

        if ( pourcentage > 0 ) {

            salaire += salaire * pourcentage / 100;
            System.out.println( "Salaire de " + nom + " augmenté de " + pourcentage + "%." );

        } else {

            System.out.println( "Pourcentage invalide." );

        }

    }

    public String getNom() {
        return nom;
    }
    public double getSalaire() {
        return salaire;
    }

    public void afficherDetails() {

        System.out.println( "Nom: " + nom + ", Salaire: " + salaire + " EUR" );

    }
}