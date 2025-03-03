## Exercice 3 : Conception d'un Module Cohésif

### Conception du Module de Rapport
Le module de rapport contiendra trois classes principales :

1. **ReportGenerator** : pour la génération du rapport.
2. **ReportDataFetcher** : pour la récupération des données nécessaires au rapport.
3. **ReportFormatter** : pour formater le rapport selon les besoins (par exemple, en format texte ou PDF).

#### 1. Classe `ReportGenerator`

La classe `ReportGenerator` sera responsable de la gestion globale du processus de génération de rapport en utilisant `ReportDataFetcher` et `ReportFormatter`.

```java
public class ReportGenerator {
    private ReportDataFetcher dataFetcher;
    private ReportFormatter formatter;

    public ReportGenerator(ReportDataFetcher dataFetcher, ReportFormatter formatter) {
        this.dataFetcher = dataFetcher;
        this.formatter = formatter;
    }

    public String generateReport() {
        // Étape 1 : Récupérer les données
        String data = dataFetcher.fetchData();
        
        // Étape 2 : Formater le rapport
        return formatter.format(data);
    }
}
```

*Explication* : `ReportGenerator` orchestre le processus de génération de rapport en appelant `fetchData` pour obtenir les données et `format` pour les formater. Cette classe est hautement cohésive car elle ne fait qu'une chose : gérer le flux de génération du rapport.

#### 2. Classe `ReportDataFetcher`

La classe `ReportDataFetcher` est responsable de la récupération des données nécessaires pour le rapport. Cette classe peut inclure des méthodes pour se connecter à une base de données ou à une API, mais ici nous simplifions avec une seule méthode `fetchData`.

```java
public class ReportDataFetcher {
    public String fetchData() {
        // Code pour récupérer les données (base de données, API, etc.)
        return "Données du rapport";
    }
}
```

*Explication* : `ReportDataFetcher` se concentre uniquement sur la récupération des données, respectant le principe de responsabilité unique et augmentant la cohésion de la classe.

#### 3. Classe `ReportFormatter`

La classe `ReportFormatter` est responsable de formater les données dans un format lisible pour le rapport. On peut imaginer plusieurs implémentations (texte, PDF, etc.), mais nous allons commencer avec une méthode simple `format`.

```java
public class ReportFormatter {
    public String format(String data) {
        // Code pour formater les données en un rapport
        return "Rapport formaté : \n" + data;
    }
}
```

*Explication* : `ReportFormatter` se concentre uniquement sur le formatage, assurant une meilleure cohésion en isolant la logique de mise en forme des données.

### Conclusion
En divisant le module en trois classes bien distinctes, nous avons créé un module hautement cohésif où chaque classe remplit une tâche spécifique. Cette structure rend le code plus facile à maintenir et à étendre. Par exemple, pour ajouter un nouveau format de rapport, il suffirait de créer une nouvelle sous-classe de `ReportFormatter`.

