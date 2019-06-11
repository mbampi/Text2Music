import org.jfugue.pattern.Pattern;

class Musica {

    private String textoMusical;
    private int instrumento;
    private int bpm;

    Musica(String textoMusical, int instrumento, int bpm) {
        this.textoMusical = textoMusical;
        this.instrumento = instrumento;
        this.bpm = bpm;
    }

    Pattern getMusicPattern(){
        Tradutor tradutor = new Tradutor();
        String musicaTraduzida = tradutor.traduzMusica(this);
        Pattern musicPattern = new Pattern(musicaTraduzida);
        return musicPattern;
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
