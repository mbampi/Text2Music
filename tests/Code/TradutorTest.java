package Code;

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

        assertEquals("X[Volume]=10000 I1 T120 A0 A0 B0 B0 B0 X[Volume]=10000 C0 C0 C0 ", musicaTraduzida);
    }

    @Test
    public void traduzMusica2() {
        String textoMusical = "Ab1; 3DEFfgAD\n" + "!oU?CDEFGd\n";
        int instrumentoInicial = 4;
        int bpmInicial = 40;
        Musica musica = new Musica(textoMusical, instrumentoInicial, bpmInicial);
        Tradutor tradutor =  new Tradutor();
        String musicaTraduzida = tradutor.traduzMusica(musica).toString();

        assertEquals("X[Volume]=10000 I4 T40 A0 A0 I5 I75 X[Volume]=10000 I78 D0 E0 F0 F0 R A0 D0 I14 I6 X[Volume]=11000 X[Volume]=12100  C1 D1 E1 F1 G1 G1 I14 ", musicaTraduzida);
    }

    @Test
    public void traduzMusicaInicio() {
        String textoMusical = "";
        int instrumentoInicial = 40;
        int bpmInicial = 62;
        Musica musica = new Musica(textoMusical, instrumentoInicial, bpmInicial);
        Tradutor tradutor =  new Tradutor();
        String musicaTraduzida = tradutor.traduzMusica(musica).toString();

        assertEquals("X[Volume]=10000 I40 T62 ", musicaTraduzida);
    }

}