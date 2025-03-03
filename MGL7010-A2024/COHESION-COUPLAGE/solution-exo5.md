## Exercice 5 : Défi de Programmation en Binôme

**Classe initial :**

```java
public class UserManager {
    public void createUser(String name) {
        // logique pour créer un utilisateur
    }

    public void deleteUser(String name) {
        // logique pour supprimer un utilisateur
    }

    public void sendNotification(String message) {
        // logique pour envoyer une notification
    }
}
```

### Analyse de la Cohésion
La classe `UserManager` a plusieurs responsabilités :
1. La création d'utilisateurs (`createUser`).
2. La suppression d'utilisateurs (`deleteUser`).
3. L'envoi de notifications (`sendNotification`).

Cette classe manque de cohésion car elle mélange des responsabilités liées à la gestion des utilisateurs et à la communication.

### Solution proposée
Pour améliorer la classe `UserManager`, nous allons la refactoriser en créant deux nouvelles classes :
1. **UserManager** : pour gérer la création et la suppression des utilisateurs.
2. **NotificationService** : pour gérer l'envoi de notifications.

#### 1. Classe `UserManager`

La classe `UserManager` sera responsable uniquement de la gestion des utilisateurs.

```java
public class UserManager {
    public void createUser(String name) {
        // logique pour créer un utilisateur
    }

    public void deleteUser(String name) {
        // logique pour supprimer un utilisateur
    }
}
```

*Explication* : `UserManager` est maintenant concentrée sur la gestion des utilisateurs, ce qui améliore la cohésion.

#### 2. Classe `NotificationService`

La classe `NotificationService` sera responsable de l'envoi des notifications.

```java
public class NotificationService {
    public void sendNotification(String message) {
        // logique pour envoyer une notification
    }
}
```

*Explication* : `NotificationService` se concentre uniquement sur l'envoi de notifications, isolant cette responsabilité et permettant une meilleure gestion des notifications.

### Documentation des Modifications
- **UserManager** : La classe a été refactorisée pour se concentrer uniquement sur les opérations liées aux utilisateurs (création et suppression).
- **NotificationService** : Une nouvelle classe a été créée pour gérer l'envoi de notifications, séparant ainsi la logique de notification de celle de la gestion des utilisateurs.

### Conclusion
En séparant les responsabilités, nous avons amélioré la cohésion de chaque classe. Cela rend le code plus facile à maintenir et à étendre. Par exemple, si nous souhaitons modifier la manière dont les notifications sont envoyées, nous pouvons le faire sans affecter la gestion des utilisateurs.
