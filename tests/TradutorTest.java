import Code.Musica;
import Code.Tradutor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TradutorTest {

    @Test
    public void traduzMusica() {
        String textoMusical = "AABBB CCC";
        int instrumentoInicial = 1;
        int bpmInicial = 120;
        Musica musica = new Musica(textoMusical, instrumentoInicial, bpmInicial);
        Tradutor tradutor =  new Tradutor();
        String musicaTraduzida = tradutor.traduzMusica(musica).toString();

        assertEquals("X[Volume]=60 I1 T120 A0 A0 B0 B0 B0 X[Volume]=120 C0 C0 C0 ", musicaTraduzida);
    }

    @Test
    public void traduzMusicaInicio() {
        String textoMusical = "";
        int instrumentoInicial = 40;
        int bpmInicial = 62;
        Musica musica = new Musica(textoMusical, instrumentoInicial, bpmInicial);
        Tradutor tradutor =  new Tradutor();
        String musicaTraduzida = tradutor.traduzMusica(musica).toString();

        assertEquals("X[Volume]=60 I40 T62 ", musicaTraduzida);
    }

}