## Exercice 4 : Étude de Cas du Monde Réel

**Classe initial :**

```java
public class ShoppingCart {
    public void addItem(Item item) {
        // logique pour ajouter un article
    }

    public void checkout(Payment payment) {
        // logique de paiement
    }

    public void sendEmailConfirmation(User user) {
        // logique pour envoyer un email
    }
}
```

### Analyse de la Cohésion
La classe `ShoppingCart` présente trois responsabilités distinctes :
1. Gérer les articles dans le panier (`addItem`).
2. Traiter le paiement (`checkout`).
3. Envoyer une confirmation par e-mail (`sendEmailConfirmation`).

Cette classe manque de cohésion parce qu'elle combine des responsabilités différentes : gestion des articles, traitement des paiements, et envoi d'e-mails.

### Solution proposée
Nous allons diviser cette classe en trois classes distinctes, chacune ayant une seule responsabilité :
1. **ShoppingCart** : pour la gestion des articles du panier.
2. **CheckoutProcessor** : pour le traitement des paiements.
3. **EmailService** : pour l'envoi des e-mails de confirmation.

#### 1. Classe `ShoppingCart`

La nouvelle classe `ShoppingCart` sera dédiée uniquement à la gestion des articles.

```java
public class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
```

*Explication* : `ShoppingCart` est maintenant une classe cohésive, responsable uniquement de la gestion des articles du panier.

#### 2. Classe `CheckoutProcessor`

`CheckoutProcessor` s'occupera uniquement du traitement des paiements. Elle prend un `ShoppingCart` en paramètre pour accéder aux articles et traiter le paiement.

```java
public class CheckoutProcessor {
    public void checkout(ShoppingCart cart, Payment payment) {
        // logique de traitement du paiement en fonction des articles du panier
    }
}
```

*Explication* : `CheckoutProcessor` est maintenant une classe dédiée au paiement, ce qui améliore la cohésion et facilite la maintenance.

#### 3. Classe `EmailService`

`EmailService` est dédiée à l'envoi des e-mails de confirmation.

```java
public class EmailService {
    public void sendEmailConfirmation(User user) {
        // logique pour envoyer un e-mail de confirmation
    }
}
```

*Explication* : `EmailService` se concentre uniquement sur l'envoi d'e-mails, permettant une meilleure organisation et flexibilité.

### Conclusion
En séparant les responsabilités, nous avons amélioré la cohésion de chaque classe et rendu le code plus modulaire. Cette approche facilite également les tests unitaires pour chaque classe individuellement et rend le système global plus maintenable.

