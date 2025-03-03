package exo7;

abstract class CompteBancaire {

    protected double solde;
    protected String titulaire;

    public CompteBancaire( String titulaire, double soldeInitial ) {

        this.titulaire = titulaire;
        this.solde = soldeInitial;

    }

    public void deposer( double montant ) {

        if ( montant > 0 ) {

            solde += montant;
            System.out.println( montant + " EUR déposés sur le compte de " + titulaire );

        } else {

            System.out.println( "Le montant doit être positif." );

        }

    }

    public abstract void retirer( double montant );

    public void afficherSolde() {

        System.out.println( "Solde du compte de " + titulaire + " : " + solde + " EUR" );

    }

}
