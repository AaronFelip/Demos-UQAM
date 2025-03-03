## Exercice 5 : Défi de programmation en binôme avec un système complexe

**Code initial :**

```java
public class HotelBookingService {
    private RoomService roomService;
    private PaymentService paymentService;
    private NotificationService notificationService;

    public HotelBookingService(RoomService roomService, PaymentService paymentService, 
                               NotificationService notificationService) {
        this.roomService = roomService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    public void bookRoom(BookingRequest request) {
        Room room = roomService.findAvailableRoom(request);
        if (room == null) {
            throw new RuntimeException("Aucune chambre disponible");
        }
        
        // Traitement du paiement
        paymentService.processPayment(request.getPaymentDetails());

        // Confirmation de la réservation
        roomService.confirmBooking(room, request);
        notificationService.sendBookingConfirmation(request.getCustomerEmail());
    }
}
```

### Analyse de la Cohésion et du Couplage
`HotelBookingService` a plusieurs responsabilités :
1. Recherche de chambre disponible.
2. Traitement du paiement.
3. Confirmation de la réservation.
4. Envoi d'un e-mail de confirmation.

Ce code présente un couplage élevé entre `HotelBookingService` et plusieurs services. De plus, la classe manque de cohésion, car elle regroupe plusieurs opérations dans une seule méthode.

### Solution proposée
Pour améliorer la cohésion et réduire le couplage, nous allons refactoriser `HotelBookingService` en déléguant chaque étape du processus de réservation à des classes spécifiques :

1. **RoomAvailabilityChecker** : pour la recherche de chambre disponible.
2. **PaymentProcessor** : pour le traitement du paiement.
3. **BookingConfirmationService** : pour confirmer la réservation.
4. **NotificationSender** : pour envoyer des notifications de réservation.

#### Refactoring de `HotelBookingService`

##### Classe `RoomAvailabilityChecker`

```java
public class RoomAvailabilityChecker {
    private RoomService roomService;

    public RoomAvailabilityChecker(RoomService roomService) {
        this.roomService = roomService;
    }

    public Room findAvailableRoom(BookingRequest request) {
        return roomService.findAvailableRoom(request);
    }
}
```

*Explication* : `RoomAvailabilityChecker` s'occupe uniquement de la recherche de chambres disponibles, améliorant ainsi la cohésion.

##### Classe `PaymentProcessor`

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

*Explication* : `PaymentProcessor` centralise la logique de traitement des paiements, facilitant le test et la maintenance.

##### Classe `BookingConfirmationService`

```java
public class BookingConfirmationService {
    private RoomService roomService;

    public BookingConfirmationService(RoomService roomService) {
        this.roomService = roomService;
    }

    public void confirmBooking(Room room, BookingRequest request) {
        roomService.confirmBooking(room, request);
    }
}
```

*Explication* : `BookingConfirmationService` est responsable de confirmer la réservation, augmentant ainsi la modularité et simplifiant la logique de `HotelBookingService`.

##### Classe `NotificationSender`

```java
public class NotificationSender {
    private NotificationService notificationService;

    public NotificationSender(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendBookingConfirmation(String customerEmail) {
        notificationService.sendBookingConfirmation(customerEmail);
    }
}
```

*Explication* : `NotificationSender` isole la logique d'envoi de notification, permettant de modifier le processus de notification sans impacter le reste du système.

##### Nouvelle Version de `HotelBookingService`

Après refactoring, voici la nouvelle version de `HotelBookingService` :

```java
public class HotelBookingService {
    private RoomAvailabilityChecker roomAvailabilityChecker;
    private PaymentProcessor paymentProcessor;
    private BookingConfirmationService bookingConfirmationService;
    private NotificationSender notificationSender;

    public HotelBookingService(RoomAvailabilityChecker roomAvailabilityChecker, PaymentProcessor paymentProcessor,
                               BookingConfirmationService bookingConfirmationService, NotificationSender notificationSender) {
        this.roomAvailabilityChecker = roomAvailabilityChecker;
        this.paymentProcessor = paymentProcessor;
        this.bookingConfirmationService = bookingConfirmationService;
        this.notificationSender = notificationSender;
    }

    public void bookRoom(BookingRequest request) {
        // Recherche de chambre disponible
        Room room = roomAvailabilityChecker.findAvailableRoom(request);
        if (room == null) {
            throw new RuntimeException("Aucune chambre disponible");
        }

        // Traitement du paiement
        paymentProcessor.processPayment(request.getPaymentDetails());

        // Confirmation de la réservation
        bookingConfirmationService.confirmBooking(room, request);

        // Envoi de la confirmation de réservation
        notificationSender.sendBookingConfirmation(request.getCustomerEmail());
    }
}
```

*Explication* : `HotelBookingService` agit désormais comme un orchestrateur, en déléguant chaque responsabilité aux classes spécialisées, ce qui améliore la cohésion et réduit le couplage.

### Conclusion
Avec cette refactorisation, `HotelBookingService` est devenue plus cohérente et modulaire, facilitant la maintenance et les tests. Chaque classe peut être modifiée ou remplacée indépendamment, ce qui rend l'ensemble du système plus flexible.

Cela conclut la série d'exercices pour ce document. Avez-vous des questions ou souhaitez-vous approfondir certains aspects ?