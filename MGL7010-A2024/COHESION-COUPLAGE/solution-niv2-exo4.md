## Exercice 4 du niveau 2 : Étude de cas dans un système de commerce électronique

**Code initial :**

```java
public class ECommerceService {
    private OrderService orderService;
    private PaymentService paymentService;
    private EmailService emailService;
    private InventoryService inventoryService;

    public ECommerceService(OrderService orderService, PaymentService paymentService, 
                            EmailService emailService, InventoryService inventoryService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.emailService = emailService;
        this.inventoryService = inventoryService;
    }

    public void completeOrder(Order order) {
        // Vérifier l'inventaire
        if (!inventoryService.isAvailable(order.getItems())) {
            throw new RuntimeException("Articles non disponibles");
        }
        
        // Traiter le paiement
        paymentService.processPayment(order.getPaymentDetails());
        
        // Enregistrer la commande
        orderService.saveOrder(order);
        
        // Envoyer l'email de confirmation
        emailService.sendConfirmation(order);
    }
}
```

### Analyse de la Cohésion et du Couplage
`ECommerceService` centralise plusieurs responsabilités :
1. Vérification de l'inventaire.
2. Traitement du paiement.
3. Enregistrement de la commande.
4. Envoi de l'e-mail de confirmation.

Cette centralisation entraîne un couplage élevé entre `ECommerceService` et plusieurs services. De plus, la classe manque de cohésion, car elle regroupe des opérations différentes dans une seule méthode.

### Solution proposée
Pour améliorer la modularité, la cohésion et réduire le couplage, nous allons diviser `completeOrder` en étapes distinctes en utilisant des services spécialisés. Chaque étape de traitement pourra être gérée indépendamment.

#### Refactoring de `ECommerceService`

##### Classe `InventoryService`

`InventoryService` gère la vérification de la disponibilité des articles dans l'inventaire. Cette classe ne nécessite pas de modifications, mais on l'injectera dans une nouvelle classe pour gérer uniquement la vérification d'inventaire.

##### Classe `PaymentProcessor`

On crée une classe `PaymentProcessor` pour gérer le traitement des paiements de manière indépendante.

```java
public class PaymentProcessor {
    private PaymentService paymentService;

    public PaymentProcessor(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processPayment(PaymentDetails paymentDetails) {
        paymentService.processPayment(paymentDetails);
    }
}
```

*Explication* : `PaymentProcessor` encapsule la logique de traitement des paiements, réduisant le couplage entre `ECommerceService` et `PaymentService`.

##### Classe `OrderManager`

La classe `OrderManager` va gérer l'enregistrement des commandes, utilisant `OrderService`.

```java
public class OrderManager {
    private OrderService orderService;

    public OrderManager(OrderService orderService) {
        this.orderService = orderService;
    }

    public void saveOrder(Order order) {
        orderService.saveOrder(order);
    }
}
```

*Explication* : `OrderManager` est maintenant responsable de l'enregistrement des commandes, isolant cette logique dans une classe dédiée.

##### Classe `NotificationSender`

La classe `NotificationSender` s'occupe d'envoyer les e-mails de confirmation.

```java
public class NotificationSender {
    private EmailService emailService;

    public NotificationSender(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendOrderConfirmation(Order order) {
        emailService.sendConfirmation(order);
    }
}
```

*Explication* : `NotificationSender` gère l'envoi de notifications, facilitant la maintenance et les modifications futures.

##### Nouvelle Version de `ECommerceService`

Voici comment `ECommerceService` serait maintenant organisée en utilisant les nouvelles classes :

```java
public class ECommerceService {
    private InventoryService inventoryService;
    private PaymentProcessor paymentProcessor;
    private OrderManager orderManager;
    private NotificationSender notificationSender;

    public ECommerceService(InventoryService inventoryService, PaymentProcessor paymentProcessor, 
                            OrderManager orderManager, NotificationSender notificationSender) {
        this.inventoryService = inventoryService;
        this.paymentProcessor = paymentProcessor;
        this.orderManager = orderManager;
        this.notificationSender = notificationSender;
    }

    public void completeOrder(Order order) {
        // Vérifier l'inventaire
        if (!inventoryService.isAvailable(order.getItems())) {
            throw new RuntimeException("Articles non disponibles");
        }

        // Traiter le paiement
        paymentProcessor.processPayment(order.getPaymentDetails());

        // Enregistrer la commande
        orderManager.saveOrder(order);

        // Envoyer l'email de confirmation
        notificationSender.sendOrderConfirmation(order);
    }
}
```

*Explication* : `ECommerceService` agit désormais comme un orchestrateur, déléguant chaque étape du processus de commande à des classes spécialisées, améliorant ainsi la cohésion et réduisant le couplage.

### Conclusion
En utilisant des classes distinctes pour chaque étape du traitement, nous avons simplifié `ECommerceService`, renforcé la modularité et facilité la maintenance et l'extensibilité du code. Chaque service peut être testé indépendamment, rendant l'ensemble du système plus robuste.
