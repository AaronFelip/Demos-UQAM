package exo7;

class CompteCourant extends CompteBancaire {

    public CompteCourant( String titulaire, double soldeInitial ) {

        super( titulaire, soldeInitial );

    }

    @Override
    public void retirer( double montant ) {

        if ( montant > 0 && montant <= solde ) {

            solde -= montant;
            System.out.println( montant + " EUR retirés du compte courant de " + titulaire );

        } else {

            System.out.println( "Retrait impossible : solde insuffisant ou montant incorrect." );

        }

    }

}
