import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculateurTaxesTest {

    @Test
    public void testCalculerTaxe(){

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> CalculateurTaxes.calculerTaxes(0,true,true));

    }

    @Test
    public void testCalculerTaxe2(){

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> CalculateurTaxes.calculerTaxes(-7,true,true));

    }

    @Test
    public void testCalculerTaxe3(){

        assertEquals(105,CalculateurTaxes.calculerTaxes(100,true,false));

    }

    @Test
    public void testCalculerTaxe4(){

        assertEquals(110,CalculateurTaxes.calculerTaxes(100,false,true));

    }

    @Test
    public void testCalculerTaxe5(){

        assertEquals(115,CalculateurTaxes.calculerTaxes(100,true,true));

    }

    @Test
    public void testCalculerTaxe6(){

        assertEquals(100,CalculateurTaxes.calculerTaxes(100,false,false));

    }






}
