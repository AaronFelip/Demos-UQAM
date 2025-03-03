## Exercise 1 : Refactoring pour la Cohésion

**Classe initiale :**

```java
public class Utility {
    public void readFile(String filename) {
        // code pour lire un fichier
    }

    public void writeFile(String filename, String content) {
        // code pour écrire dans un fichier
    }

    public String formatString(String input) {
        // code pour formater une chaîne
        return input.trim().toUpperCase();
    }

    public void connectToDatabase(String connectionString) {
        // code pour se connecter à une base de données
    }
}
```

### Analyse de la Cohésion
La classe `Utility` a plusieurs responsabilités :
1. La lecture et l'écriture de fichiers.
2. Le formatage de chaînes de caractères.
3. La connexion à une base de données.

Cela réduit la cohésion de la classe, car elle fait trop de choses différentes. Pour une meilleure cohésion, chaque classe devrait se concentrer sur une seule responsabilité.

### Solution proposée
Nous allons diviser `Utility` en trois classes, chacune ayant une responsabilité unique :

1. **FileHandler** : pour la lecture et l'écriture de fichiers.
2. **StringFormatter** : pour le formatage de chaînes de caractères.
3. **DatabaseConnector** : pour la connexion à une base de données.

#### Classe `FileHandler`

```java
public class FileHandler {
    public void readFile(String filename) {
        // code pour lire un fichier
    }

    public void writeFile(String filename, String content) {
        // code pour écrire dans un fichier
    }
}
```

*Explication* : `FileHandler` est maintenant responsable uniquement des opérations sur les fichiers, améliorant ainsi la cohésion de cette classe.

#### Classe `StringFormatter`

```java
public class StringFormatter {
    public String formatString(String input) {
        // code pour formater une chaîne
        return input.trim().toUpperCase();
    }
}
```

*Explication* : `StringFormatter` se concentre uniquement sur le formatage de chaînes, ce qui améliore également sa cohésion.

#### Classe `DatabaseConnector`

```java
public class DatabaseConnector {
    public void connectToDatabase(String connectionString) {
        // code pour se connecter à une base de données
    }
}
```

*Explication* : `DatabaseConnector` est maintenant dédié aux opérations de connexion aux bases de données, renforçant sa cohésion.
