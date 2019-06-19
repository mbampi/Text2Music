package Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstrumentosTest {

    @Test
    public void isValidInstrument0() {
        assertTrue(Instrumentos.isValidInstrument(0));
    }

    @Test
    public void isValidInstrument127() {
        assertTrue(Instrumentos.isValidInstrument(120));
    }

    @Test
    public void isValidInstrument40() {
        assertTrue(Instrumentos.isValidInstrument(40));
    }

    @Test
    public void isValidInstrumentFalseNeg10() {
        assertFalse(Instrumentos.isValidInstrument(-10));
    }

    @Test
    public void isValidInstrumentFalseAcimaDoMax() {
        assertFalse(Instrumentos.isValidInstrument(140));
    }

    @Test
    public void getInstrumentoCode0() {
        String instrumentoCode = Instrumentos.getInstrumentoToken(0);
        assertEquals("I0", instrumentoCode);
    }

    @Test
    public void getInstrumentoCode114() {
        String instrumentoCode = Instrumentos.getInstrumentoToken(114);
        assertEquals("I114", instrumentoCode);
    }

    @Test
    public void getInstrumentoCodeInvalido160() {
        String instrumentoCode = Instrumentos.getInstrumentoToken(160);
        assertEquals("", instrumentoCode);
    }

    @Test
    public void trocaInstrumento1() {
        int novoInstrumento = Instrumentos.trocaInstrumento(0, 1);
        assertEquals(1, novoInstrumento);
    }

    @Test
    public void trocaInstrumentoAbaixoDoMin() {
        int novoInstrumento = Instrumentos.trocaInstrumento(10, -15);
        assertEquals(10, novoInstrumento);
    }

    @Test
    public void trocaInstrumentoAcimaDoMax() {
        int novoInstrumento = Instrumentos.trocaInstrumento(100, 100);
        assertEquals(100, novoInstrumento);
    }

    @Test
    public void trocaInstrumento10Mais102() {
        int novoInstrumento = Instrumentos.trocaInstrumento(10, 102);
        assertEquals(112, novoInstrumento);
    }
}