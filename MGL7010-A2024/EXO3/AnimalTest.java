package exo3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    public void testCreationAnimal() {
        Animal animal = new Animal("Rex");
        assertEquals("Rex", animal.nom, "Le nom de l'animal n'est pas correct");
    }

    @Test
    public void testParler() {
        Animal animal = new Animal("Rex");
        assertDoesNotThrow(animal::parler, "Erreur lors de l'appel de la méthode parler");
    }
}

