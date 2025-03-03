package exo8;

public class Main {

    public static void main( String[] args ) {

        Etudiant etudiant1 = new Etudiant( "Alice" );
        Professeur professeur1 = new Professeur( "Dr. Smith" );
        Administrateur admin1 = new Administrateur( "Mme. Martin" );

        etudiant1.inscrireCours( "Mathématiques" );
        professeur1.assignerNote( etudiant1, "Mathématiques", 18.5 );
        admin1.gererInscription( etudiant1, "Physique" );

        etudiant1.afficherRole();
        professeur1.afficherRole();
        admin1.afficherRole();

    }

}
