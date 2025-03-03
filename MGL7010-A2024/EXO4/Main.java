package exo4;

public class Main {

    public static void main(String[] args) {

        CompteBancaire compte = new CompteBancaire("Alice", 1000.0);
        compte.afficherSolde();
        compte.deposer(200);
        compte.retirer(150);
        compte.afficherSolde();
        compte.retirer(2000); // Cas de retrait impossible

    }

}
