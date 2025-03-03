## Exercice 1 du niveau 2 : Refactoring d'une classe complexe pour la cohésion

**Code initial :**

```java
public class OrderProcessingService {
    private OrderRepository orderRepository;
    private EmailService emailService;

    public void processOrder(Order order) {
        // Validation de la commande
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("La commande doit avoir au moins un article");
        }
        
        // Enregistrement de la commande dans la base de données
        orderRepository.save(order);
        
        // Envoi de l'email de confirmation
        emailService.sendOrderConfirmation(order);
        
        // Journalisation du traitement de la commande
        System.out.println("Commande traitée : " + order.getId());
        
        // Génération et impression de la facture
        Invoice invoice = generateInvoice(order);
        System.out.println("Facture : " + invoice);
    }

    private Invoice generateInvoice(Order order) {
        // Logique pour générer la facture
        return new Invoice(order);
    }
}
```

### Analyse de la Cohésion
La classe `OrderProcessingService` remplit plusieurs rôles :
1. Valider la commande.
2. Enregistrer la commande dans la base de données.
3. Envoyer un e-mail de confirmation.
4. Journaliser le traitement de la commande.
5. Générer une facture.

Cette classe manque de cohésion car elle regroupe plusieurs responsabilités qui pourraient être déléguées à des classes plus spécifiques.

### Solution proposée
Pour améliorer la cohésion, nous allons diviser `OrderProcessingService` en plusieurs classes dédiées :

1. **OrderValidator** : pour valider la commande.
2. **OrderRepository** : pour enregistrer la commande (restera inchangée car elle est déjà utilisée de manière autonome).
3. **EmailService** : pour l'envoi d'e-mails (restera inchangée également).
4. **OrderLogger** : pour la journalisation du traitement de la commande.
5. **InvoiceService** : pour générer la facture.

#### Refactoring de `OrderProcessingService`

Après refactoring, `OrderProcessingService` va principalement orchestrer les différentes étapes, en déléguant chaque responsabilité aux classes spécifiques.

##### Classe `OrderValidator`

```java
public class OrderValidator {
    public void validate(Order order) {
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("La commande doit avoir au moins un article");
        }
    }
}
```

*Explication* : `OrderValidator` se concentre uniquement sur la validation de la commande, renforçant ainsi la cohésion de cette classe.

##### Classe `OrderLogger`

```java
public class OrderLogger {
    public void logOrderProcessing(Order order) {
        System.out.println("Commande traitée : " + order.getId());
    }
}
```

*Explication* : `OrderLogger` est une classe dédiée à la journalisation, rendant le code plus modulaire et cohérent.

##### Classe `InvoiceService`

```java
public class InvoiceService {
    public Invoice generateInvoice(Order order) {
        // Logique pour générer la facture
        return new Invoice(order);
    }
}
```

*Explication* : `InvoiceService` s'occupe de la génération de la facture, séparant cette responsabilité et simplifiant ainsi le processus.

##### Nouvelle Version de `OrderProcessingService`

```java
public class OrderProcessingService {
    private OrderRepository orderRepository;
    private EmailService emailService;
    private OrderValidator validator;
    private OrderLogger logger;
    private InvoiceService invoiceService;

    public OrderProcessingService(OrderRepository orderRepository, EmailService emailService,
                                  OrderValidator validator, OrderLogger logger, InvoiceService invoiceService) {
        this.orderRepository = orderRepository;
        this.emailService = emailService;
        this.validator = validator;
        this.logger = logger;
        this.invoiceService = invoiceService;
    }

    public void processOrder(Order order) {
        // Validation de la commande
        validator.validate(order);

        // Enregistrement de la commande dans la base de données
        orderRepository.save(order);

        // Envoi de l'email de confirmation
        emailService.sendOrderConfirmation(order);

        // Journalisation du traitement de la commande
        logger.logOrderProcessing(order);

        // Génération et impression de la facture
        Invoice invoice = invoiceService.generateInvoice(order);
        System.out.println("Facture : " + invoice);
    }
}
```

*Explication* : `OrderProcessingService` orchestre maintenant le processus de commande en utilisant des services spécialisés, rendant la classe plus cohésive et plus facile à maintenir.

### Conclusion
En déléguant chaque responsabilité à une classe distincte, nous avons significativement amélioré la cohésion et la modularité du code. Chaque classe est maintenant plus facile à comprendre, à tester et à maintenir.
