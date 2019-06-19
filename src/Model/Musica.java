package Model;

import org.jfugue.pattern.Pattern;

public class Musica {

    private String textoMusical;
    private int instrumento;
    private int ritmo;

    public Musica(String textoMusical, int instrumento, int ritmo) {
        this.textoMusical = textoMusical;
        this.instrumento = instrumento;
        this.ritmo = ritmo;
    }

    public Pattern getMusicPattern(){
        Tradutor tradutor = new Tradutor();
        String musicaTraduzida = tradutor.traduzMusica(this);
        return new Pattern(musicaTraduzida);
    }

    String getTextoMusical() {
        return textoMusical;
    }

    int getInstrumento() {
        return instrumento;
    }

    int getRitmo() {
        return ritmo;
    }
}
