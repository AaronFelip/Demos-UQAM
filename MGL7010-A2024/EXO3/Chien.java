package exo3;

class Chien extends Animal {

    public Chien(String nom) {
        super(nom);
    }

    @Override
    public void parler() {
        System.out.println(nom + " aboie : Woof Woof !");
    }
}