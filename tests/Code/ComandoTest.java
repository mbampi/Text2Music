package Code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComandoTest {
    private Comando comando;

    @Before
    public void initializeComando(){
        comando = new Comando();
        comando.setComando('A');
        comando.setComando('B');
    }

    @Test
    public void getComando() {
        assertEquals('B', comando.getComando());
    }

    public void getComandoDigito(){
        comando.setComando('1');
        assertEquals(1, comando.getComandoDigito());
    }

    @Test
    public void getUltimoComando() {
        assertEquals('A', comando.getUltimoComando());
    }

    @Test
    public void setComando() {
        comando.setComando('D');
        assertEquals('D', comando.getComando());
    }

    @Test
    public void isDigito() {
        comando.setComando('1');
        assertTrue(comando.isDigito());
    }

    @Test
    public void isDigitoFalso() {
        comando.setComando('9');
        assertTrue(comando.isDigito());
    }

    @Test
    public void ultimoComandoIsNota() {
        comando.setComando('A');
        comando.setComando('3');
        assertTrue(comando.ultimoComandoIsNota());
    }

    @Test
    public void ultimoComandoIsNotaFalso() {
        comando.setComando('5');
        comando.setComando('A');
        assertFalse(comando.ultimoComandoIsNota());
    }

    @Test
    public void comandoIsNota() {
        comando.setComando('A');
        assertTrue(comando.comandoIsNota());
    }

    @Test
    public void comandoIsNotaFalso() {
        comando.setComando('a');
        assertFalse(comando.comandoIsNota());
    }

    @Test
    public void isOUI() {
        comando.setComando('O');
        assertTrue(comando.isOUI());
    }

    @Test
    public void isOUIFalso() {
        comando.setComando('E');
        assertFalse(comando.isOUI());
    }

    @Test
    public void isConsoante() {
        comando.setComando('n');
        assertTrue(comando.isConsoante());
    }

    @Test
    public void isConsoante2() {
        comando.setComando('G');
        assertTrue(comando.isConsoante());
    }

    @Test
    public void isConsoanteFalso() {
        comando.setComando('I');
        assertFalse(comando.isConsoante());
    }
}