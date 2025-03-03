## Guide d'utilisation rapide pour Junit

JUnit est un framework de test unitaire pour Java, conçu pour automatiser et simplifier le processus de test des 
composants individuels d'une application Java. Il permet aux développeurs de définir des cas de test, d'exécuter 
ces tests et de vérifier si le comportement du code testé est conforme aux attentes. Les caractéristiques clés de 
JUnit incluent l'organisation des tests en classes de test, l'utilisation d'annotations pour spécifier les méthodes 
de test, l'assertion des résultats attendus et la gestion des exceptions. JUnit favorise les principes de la 
programmation orientée objet, notamment l'encapsulation et l'indépendance des tests. Il est largement utilisé dans le 
développement logiciel Java pour assurer la qualité et la fiabilité du code en identifiant les erreurs et en facilitant 
les tests automatisés.

Voici quelques exemples d'utilisation qui pourraient vous aider a réaliser des tests unitaire.

#### Test d'égalité simple :
```agsl
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }
}
```

#### Test de déclenchement d'exception :
```agsl
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });
    }
}

```

#### Test de liste vide :
```agsl
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.ArrayList;

public class ListTest {
    @Test
    public void testEmptyList() {
        List<String> emptyList = new ArrayList<>();
        assertTrue(emptyList.isEmpty());
    }
}
```

#### Test de chaînes de caractères :
```agsl
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsTest {
    @Test
    public void testConcatenate() {
        String result = StringUtils.concatenate("Hello, ", "JUnit");
        assertEquals("Hello, JUnit", result);
    }
}

```

#### Test de tableau (vérifier la taille et les éléments d'un tableau) :
```agsl
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayTest {
    @Test
    public void testArray() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = ArrayUtils.createArray();
        
        assertArrayEquals(expected, actual);
        assertEquals(5, actual.length);
    }
}
```

#### Test de méthodes avec des assertions multiples :
```agsl
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexTest {
    @Test
    public void testComplexMethod() {
        ComplexNumber result = ComplexMath.complexOperation();
        
        assertTrue(result.getReal() > 0);
        assertFalse(result.isImaginary());
        assertEquals(10.0, result.getMagnitude(), 0.001);
    }
}
```

#### Test de gestion des chaînes vides ou nulles :
```agsl
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilTest {
    @Test
    public void testStringManipulation() {
        String nullString = StringUtil.nullifyString(null);
        assertNull(nullString);
        
        String emptyString = StringUtil.emptyifyString("");
        assertNotNull(emptyString);
        assertTrue(emptyString.isEmpty());
    }
}
```

#### Test d'égalité d'objets personnalisés :
```agsl
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    @Test
    public void testPersonEquality() {
        Person person1 = new Person("John", 30);
        Person person2 = new Person("John", 30);
        
        assertEquals(person1, person2);
    }
}
```

#### Test de performance (vérifier le temps d'exécution) :
```agsl
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class PerformanceTest {
    @Test
    public void testPerformance() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            // Code à tester pour s'assurer qu'il s'exécute en moins d'une seconde
            PerformanceChecker.runPerformanceTest();
        });
    }
}
```

#### Test de classe avec des dépendances (utilisation de Mockito pour simuler les dépendances) :
```agsl
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceTest {
    @Test
    public void testCalculateTotalPrice() {
        Product product1 = new Product("Product 1", 10.0);
        Product product2 = new Product("Product 2", 20.0);
        
        PriceService priceService = mock(PriceService.class);
        when(priceService.getPrice(product1)).thenReturn(10.0);
        when(priceService.getPrice(product2)).thenReturn(20.0);
        
        OrderService orderService = new OrderService(priceService);
        
        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);
        
        double totalPrice = orderService.calculateTotalPrice(order);
        assertEquals(30.0, totalPrice, 0.001);
    }
}
```
