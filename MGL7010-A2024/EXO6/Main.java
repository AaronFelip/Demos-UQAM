package exo6;

public class Main {
    public static void main(String[] args) {

        Entreprise monEntreprise = new Entreprise();

        Employe employe1 = new Employe("Jean Dupont", 2500);
        Employe employe2 = new Employe("Marie Curie", 3000);

        monEntreprise.ajouterEmploye(employe1);
        monEntreprise.ajouterEmploye(employe2);

        monEntreprise.afficherEmployes();

        employe1.augmenterSalaire(10);
        monEntreprise.afficherEmployes();

    }

}