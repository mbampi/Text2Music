package Code;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotaTest {

    @Test
    public void getNotaToken() {
        Nota nota = new Nota();
        assertEquals("A0", nota.getNotaToken('A'));
    }

    @Test
    public void getNotaTokenOitava1() {
        Nota nota = new Nota();
        nota.aumentaOitava();
        assertEquals("A1", nota.getNotaToken('A'));
    }

    @Test
    public void getNotaTokenOitava2() {
        Nota nota = new Nota();
        nota.aumentaOitava();
        nota.aumentaOitava();
        assertEquals("A2", nota.getNotaToken('A'));
    }
}