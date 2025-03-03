package exo3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ChatTest {

    @Test
    public void testCreationChat() {
        Chat chat = new Chat("Minou");
        assertEquals("Minou", chat.nom, "Le nom du chat n'est pas correct");
    }

    @Test
    public void testParler() {
        Chat chat = new Chat("Minou");
        assertDoesNotThrow(chat::parler, "Erreur lors de l'appel de la méthode parler pour le chat");
    }
}

