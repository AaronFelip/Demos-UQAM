### Mock
#### Partie 1: Présentation de Mockito
#### Partie 2: Quelques tests unitaire
#### Partie 3: Ajout dans le pom.xml


### Présentation de Mockito
Un mock object (objet simulé) est un objet créé pour simuler le comportement d'un objet réel, 
souvent dans le contexte de tests unitaires. L'utilisation de mock objects est une pratique 
courante en programmation orientée objet, et elle est particulièrement répandue dans le domaine 
des tests logiciels. Voici un bref résumé de ce qu'est un mock object et de son utilité :

1 - Simulation de Comportement : Un mock object imite le comportement d'un objet réel, généralement 
en fournissant des réponses pré-définies aux appels de méthodes spécifiques.

2 - Tests Unitaires : Les mock objects sont souvent utilisés lors des tests unitaires pour isoler 
la classe ou la méthode que vous souhaitez tester. En remplaçant de véritables dépendances 
par des mock objects, vous pouvez contrôler l'environnement de test et vous concentrer sur 
le comportement spécifique de la partie de code que vous testez.

3 - Contrôle d'État et de Flux : Les mock objects permettent de contrôler le flux d'exécution 
et l'état interne pendant les tests. Vous pouvez spécifier les réponses aux méthodes appelées, 
simuler des exceptions, et vérifier si certaines méthodes ont été appelées avec les arguments 
attendus.

4 - Réduction de la Dépendance : En utilisant des mock objects, vous pouvez tester une unité de 
code de manière isolée, sans dépendre d'autres parties du système. Cela rend les tests plus 
fiables, car les erreurs potentielles sont limitées à l'unité testée.

5 - Accélération des Tests : En évitant l'appel à de véritables services externes (bases de données, 
services web, etc.) pendant les tests unitaires, vous accélérez l'exécution des tests, car vous 
n'avez pas besoin de mettre en place et de nettoyer des ressources réelles.

En résumé, les mock objects sont des outils puissants pour simplifier et améliorer les tests 
unitaires en permettant aux développeurs de contrôler l'environnement de test, de simuler des 
scénarios spécifiques, et de faciliter l'isolation des composants logiciels pour des tests 
plus efficaces et fiables.

___

### Quelques tests unitaire
Supposons une classe Calculator qui a une méthode add que nous voulons tester.

**Test pour vérifier que add renvoie la somme correcte en utilisant un mock simple :**
```agsl
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        // Création du mock object
        CalculatorService calculatorService = mock(CalculatorService.class);

        // Définition du comportement du mock object
        when(calculatorService.add(3, 4)).thenReturn(7);

        // Création de l'objet Calculator avec le mock object injecté
        Calculator calculator = new Calculator(calculatorService);

        // Appel de la méthode à tester
        int result = calculator.add(3, 4);

        // Vérification du résultat
        assertEquals(7, result);
    }
}
```

Quelques tests supplémentaire:
```agsl
import org.junit.Test;
import static org.junit.Assert.*;

// Ne pas oublier d'importer la librairie
import static org.mockito.Mockito.*;

public class CalculatorTest {

    // Voici un test tel que vous les connaissiez déjà
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(3, 4);
        assertEquals(7, result);
    }

    // Voici un test a l'aide de mockito
    @Test
    public void testAddWithMock() {
        Calculator calculator = new Calculator();
        CalculatorService calculatorService = mock(CalculatorService.class);

        when(calculatorService.add(3, 4)).thenReturn(7);
        calculator.setCalculatorService(calculatorService);

        int result = calculator.add(3, 4);
        assertEquals(7, result);
    }

    @Test
    public void testAddWithMockVerify() {
        Calculator calculator = new Calculator();
        CalculatorService calculatorService = mock(CalculatorService.class);

        when(calculatorService.add(3, 4)).thenReturn(7);
        calculator.setCalculatorService(calculatorService);

        int result = calculator.add(3, 4);
        assertEquals(7, result);

        verify(calculatorService, times(1)).add(3, 4);
    }

    @Test
    public void testAddWithMockMultipleInvocations() {
        Calculator calculator = new Calculator();
        CalculatorService calculatorService = mock(CalculatorService.class);

        when(calculatorService.add(3, 4)).thenReturn(7).thenReturn(10);
        calculator.setCalculatorService(calculatorService);

        int result1 = calculator.add(3, 4);
        int result2 = calculator.add(3, 4);

        assertEquals(7, result1);
        assertEquals(10, result2);
    }

    @Test(expected = RuntimeException.class)
    public void testAddWithMockException() {
        Calculator calculator = new Calculator();
        CalculatorService calculatorService = mock(CalculatorService.class);

        when(calculatorService.add(3, 4)).thenThrow(new RuntimeException("Custom exception"));
        calculator.setCalculatorService(calculatorService);

        calculator.add(3, 4);
    }
}
```

___

### Ajout dans le pom.xml
Si vous utilisez des frameworks de test comme JUnit et que vous souhaitez utiliser des mock objects, 
vous devrez ajouter la dépendance appropriée à votre fichier pom.xml pour que Maven puisse télécharger 
les bibliothèques nécessaires lors de la construction de votre projet.

Si vous utilisez le framework Mockito pour créer des mock objects en Java, vous pouvez ajouter la 
dépendance suivante à votre fichier pom.xml :
```agsl
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>3.11.2</version> <!-- Assurez-vous d'utiliser la version la plus récente -->
    <scope>test</scope>
</dependency>
```
N'oubliez pas de recharger votre projet après avoir modifié le fichier pom.xml pour que Maven 
télécharge les nouvelles dépendances. Vous pouvez le faire en exécutant la commande suivante 
dans votre terminal ou votre invite de commandes, à la racine de votre projet :

```agsl
mvn clean install
```

Cela téléchargera les dépendances spécifiées dans votre fichier pom.xml et les ajoutera au
classpath de votre projet. Une fois cela fait, vous devriez être en mesure d'utiliser 
Mockito dans vos tests unitaires.

