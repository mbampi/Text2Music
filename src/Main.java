
import org.jfugue.pattern.Pattern;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Java Text2Music!");
        Scanner scan = new Scanner(System.in);

        System.out.println("Texto Musical: ");
        String textoMusical = scan.nextLine();

        System.out.println("Codigo Instrumento: ");
        int instrumentoInicial = scan.nextInt();

        System.out.println("BPM: ");
        int bpmInicial = scan.nextInt();

        Musica musica = new Musica(textoMusical, instrumentoInicial, bpmInicial);

        Tradutor tradutor =  new Tradutor();
        Pattern musicaTraduzida = tradutor.traduzMusica(musica);
        System.out.println(musicaTraduzida);
        Tocador.toca(musicaTraduzida);
    }

    /*
    * --- MUSIC TOKENS ---
    *
    * Function              Command     Example             Max
    *
    * Instrument            I           I[Piano] or I12     127
    * Rest                  R           R
    * Tempo(BPM)            T           T120
    * Volume                X[Volume]   X[Volume]=10200     16383
    * Note values Octave    [<int>]     [60]                127       obs: table in GoogleDrive -> TCP
    *
    * */

    /*
    * Pattern pattern = new Pattern("X[Volume]=10000 C D E F G R A B " +
    *                              "I[Acoustic_Bass] X[Volume]=0 C D E F G A B I " +
    *                              "X[Volume]=5200 I[Guitar] C D E F G A B" );
    *
    * Pattern pattern = new Pattern(musicalText);
    */
}
