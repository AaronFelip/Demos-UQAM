package exo7;

public class Main {

    public static void main( String[] args ) {

        CompteCourant compteCourant = new CompteCourant( "Alice", 500 );
        CompteEpargne compteEpargne = new CompteEpargne( "Bob", 300 );
        CompteEntreprise compteEntreprise = new CompteEntreprise( "Charlie", 1000 );

        compteCourant.retirer( 100 );
        compteEpargne.retirer( 150 );
        compteEntreprise.retirer( 200 );

        compteCourant.afficherSolde();
        compteEpargne.afficherSolde();
        compteEntreprise.afficherSolde();

    }

}
