package exo7;

class CompteEpargne extends CompteBancaire {

    private final double seuil = 100.0;

    public CompteEpargne(String titulaire, double soldeInitial) {

        super(titulaire, soldeInitial);

    }

    @Override
    public void retirer(double montant) {

        if (montant > 0 && (solde - montant) >= seuil) {

            solde -= montant;
            System.out.println(montant + " EUR retirés du compte épargne de " + titulaire);

        } else {

            System.out.println("Retrait impossible : solde inférieur au seuil minimum de " + seuil + " EUR.");

        }
    }

}
