# UML

## EXO1
Basé sur le code suivant, crée un diagramme UML la classe Voiture.

```java
class Voiture {
    String marque;
    String couleur;
    int vitesseMax;

    // Constructeur
    public Voiture(String marque, String couleur, int vitesseMax) {
        this.marque = marque;
        this.couleur = couleur;
        this.vitesseMax = vitesseMax;
    }

    // Méthode pour afficher les détails de la voiture
    public void afficherDetails() {
        System.out.println("Marque: " + this.marque);
        System.out.println("Couleur: " + this.couleur);
        System.out.println("Vitesse Maximale: " + this.vitesseMax + " km/h");
    }
}
```

**REMARQUE :**

**Portée de package** (*default*)
- **Accessibilité** : Si tu ne mets pas de modificateur d'accès (comme `private`, `public`, ou `protected`), l'attribut ou la méthode est accessible uniquement aux classes du **même package**. En d'autres termes, seules les classes qui se trouvent dans le même dossier (ou package) peuvent y accéder.
- **Utilisation** : Utilisé lorsqu'on souhaite limiter l'accès à des classes appartenant au même package.
- **UML** : Représenté par le symbole '~'.

### Exemple :
```java
class Voiture {
    String marque; // Accessible uniquement dans le même package
}
```

### Comparaison avec public :
- **public** : accessible de partout, même depuis d'autres packages.
- **portée de package** (*default*) : accessible uniquement dans le même package, pas à l'extérieur.

### Exemple :
```java
public class Voiture {
    public String marque; // Accessible de partout
}
```

### Diagramme : 
![UML exo 1](/images/uml-exo1.png)


## EXO8

**REMARQUE** : 

N'oubliez pas vos `getters` si vous avez besoin de récuperer vos attributs d'instances
`privée`!

```java
import java.util.ArrayList;

interface Personne {
    void afficherRole();
}

class Etudiant implements Personne {
    private String nom;
    private ArrayList<String> cours;

    public Etudiant(String nom) {
        this.nom = nom;
        this.cours = new ArrayList<>();
    }

    public void inscrireCours(String cours) {
        this.cours.add(cours);
        System.out.println(nom + " s'est inscrit au cours : " + cours);
    }

    @Override
    public void afficherRole() {
        System.out.println(nom + " est un étudiant.");
    }

    @Override
    public String toString() {
        return nom;
    }
}

class Professeur implements Personne {
    private String nom;

    public Professeur(String nom) {
        this.nom = nom;
    }

    public void assignerNote(Etudiant etudiant, String cours, double note) {
        System.out.println(nom + " a assigné une note de " + note + " à " + etudiant + " pour le cours " + cours);
    }

    @Override
    public void afficherRole() {
        System.out.println(nom + " est un professeur.");
    }

    @Override
    public String toString() {
        return nom;
    }
}

class Administrateur implements Personne {
    private String nom;

    public Administrateur(String nom) {
        this.nom = nom;
    }

    public void gererInscription(Etudiant etudiant, String cours) {
        System.out.println(nom + " gère l'inscription de l'étudiant " + etudiant + " au cours : " + cours);
    }

    @Override
    public void afficherRole() {
        System.out.println(nom + " est un administrateur.");
    }

    @Override
    public String toString() {
        return nom;
    }
}
```
### Diagramme
![UML exo 8](/images/uml-exo8.png)

## EXO9

```java
interface Forme {
    double calculerAire();
    double calculerPerimetre();
}

class Cercle implements Forme {
    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public double calculerAire() {
        return Math.PI * rayon * rayon;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * Math.PI * rayon;
    }
}

class Rectangle implements Forme {
    private double largeur;
    private double hauteur;

    public Rectangle(double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    @Override
    public double calculerAire() {
        return largeur * hauteur;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * (largeur + hauteur);
    }
}

class Triangle implements Forme {
    private double coteA;
    private double coteB;
    private double coteC;

    public Triangle(double coteA, double coteB, double coteC) {
        this.coteA = coteA;
        this.coteB = coteB;
        this.coteC = coteC;
    }

    @Override
    public double calculerAire() {
        double s = (coteA + coteB + coteC) / 2;
        return Math.sqrt(s * (s - coteA) * (s - coteB) * (s - coteC));
    }

    @Override
    public double calculerPerimetre() {
        return coteA + coteB + coteC;
    }
}
```
### Diagramme
![UML exo 9](/images/uml-exo9.png)



