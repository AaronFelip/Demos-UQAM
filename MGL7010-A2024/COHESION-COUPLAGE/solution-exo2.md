## Exercice 2 : Analyse du Couplage

**Classes initiale :**

```java
public class Order {
    private Customer customer;
    private Payment payment;

    public void processOrder() {
        customer = new Customer();
        payment = new Payment();
        // logique de traitement de la commande
    }
}

public class Customer {
    // Attributs et méthodes liés au client
}

public class Payment {
    // Attributs et méthodes liés au paiement
}
```

### Analyse du Couplage
La classe `Order` crée elle-même des instances de `Customer` et `Payment`, ce qui signifie qu'elle est fortement couplée à ces classes. Cela rend la classe `Order` moins flexible et rend son code plus difficile à tester, car `Order` dépend directement des implémentations spécifiques de `Customer` et `Payment`.

### Solution proposée
Pour réduire le couplage, nous pouvons utiliser **l'injection de dépendances**. Plutôt que de créer des instances de `Customer` et `Payment` dans `Order`, nous allons les injecter via le constructeur. Cela permet à `Order` de fonctionner avec n'importe quelle implémentation de `Customer` et `Payment`, tant qu'elles respectent l'interface attendue.

#### Modification de la classe `Order` :

```java
public class Order {
    private Customer customer;
    private Payment payment;

    // Injection de dépendances via le constructeur
    public Order(Customer customer, Payment payment) {
        this.customer = customer;
        this.payment = payment;
    }

    public void processOrder() {
        // logique de traitement de la commande
    }
}
```

### Explication
* En injectant `Customer` et `Payment` via le constructeur, `Order` n'est plus responsable de la création de ces objets. Cela réduit le couplage car `Order` ne dépend plus des implémentations spécifiques de `Customer` et `Payment`.
* Ce changement rend également le code plus facile à tester, car on peut injecter des objets `Customer` et `Payment` fictifs ou simulés dans `Order` lors des tests unitaires.
