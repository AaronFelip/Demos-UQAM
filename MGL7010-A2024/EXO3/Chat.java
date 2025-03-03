package exo3;

class Chat extends Animal {

    public Chat(String nom) {
        super(nom);
    }

    @Override
    public void parler() {
        System.out.println(nom + " miaule : Miaou Miaou !");
    }
}
