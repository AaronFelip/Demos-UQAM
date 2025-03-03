## Exercice 2 du niveau 2 : Analyse et Refactoring d'un Scénario de Couplage Étroit

**Code initial :**

```java
public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private User user;

    public void addItem(Item item) {
        items.add(item);
    }

    public void checkout() {
        Payment payment = new Payment();
        payment.processPayment(user, calculateTotal());
        EmailService emailService = new EmailService();
        emailService.sendCheckoutConfirmation(user);
    }

    private double calculateTotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
}
```

### Analyse du Couplage
Dans cette implémentation, `ShoppingCart` crée des instances de `Payment` et `EmailService` directement dans la méthode `checkout`, ce qui entraîne un couplage fort entre ces classes. Cela limite la flexibilité de `ShoppingCart`, car il ne peut pas fonctionner avec différentes implémentations de `Payment` et `EmailService`.

### Solution proposée
Pour réduire le couplage, nous allons injecter `Payment` et `EmailService` dans `ShoppingCart`, soit via le constructeur, soit via des setters. Cela permettra d'utiliser différentes implémentations de `Payment` et `EmailService` sans modifier `ShoppingCart`.

#### Refactoring de `ShoppingCart`

##### Mise à jour de `ShoppingCart` avec l'injection de dépendances

```java
public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private User user;
    private Payment payment;
    private EmailService emailService;

    public ShoppingCart(User user, Payment payment, EmailService emailService) {
        this.user = user;
        this.payment = payment;
        this.emailService = emailService;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void checkout() {
        payment.processPayment(user, calculateTotal());
        emailService.sendCheckoutConfirmation(user);
    }

    private double calculateTotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
}
```

*Explication* : En injectant `Payment` et `EmailService` via le constructeur, `ShoppingCart` n'est plus couplé aux implémentations spécifiques de ces classes, rendant le code plus flexible et modulaire.

### Conclusion
Avec cette approche, nous avons réduit le couplage de `ShoppingCart` en déléguant la responsabilité de la création des instances de `Payment` et `EmailService`. Cela rend `ShoppingCart` plus adaptable et plus facile à tester, car nous pouvons facilement injecter des versions de test de `Payment` et `EmailService`.

