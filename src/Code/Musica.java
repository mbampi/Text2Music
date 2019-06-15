package Code;

import org.jfugue.pattern.Pattern;

public class Musica {

    private String textoMusical;
    private int instrumento;
    private int bpm;

    public Musica(String textoMusical, int instrumento, int bpm) {
        this.textoMusical = textoMusical;
        this.instrumento = instrumento;
        this.bpm = bpm;
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

    int getBpm() {
        return bpm;
    }
}
