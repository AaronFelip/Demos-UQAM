package exo4;

class CompteBancaire {
    private double solde;
    private String titulaire;

    public CompteBancaire(String titulaire, double soldeInitial) {
        this.titulaire = titulaire;
        this.solde = soldeInitial;
    }

    // Méthode pour déposer de l'argent
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println(montant + " EUR déposés sur le compte de " + titulaire);
        } else {
            System.out.println("Le montant doit être positif.");
        }
    }

    // Méthode pour retirer de l'argent
    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println(montant + " EUR retirés du compte de " + titulaire);
        } else {
            System.out.println("Retrait impossible : solde insuffisant ou montant incorrect.");
        }
    }

    public double getSolde() {
        return solde;
    }

    // Méthode pour afficher le solde
    public void afficherSolde() {
        System.out.println("Le solde du compte de " + titulaire + " est de " + solde + " EUR.");
    }
}
