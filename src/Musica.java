import org.jfugue.pattern.Pattern;

public class Musica {

    private String textoMusical;
    private int instrumento;
    private int bpm;

    Musica(String textoMusical, int instrumento, int bpm) {
        this.textoMusical = textoMusical;
        this.instrumento = instrumento;
        this.bpm = bpm;
    }

    public Pattern getMusicPattern(){
        Tradutor tradutor = new Tradutor();
        return tradutor.traduzMusica(this);
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

    public void setTextoMusical(String textoMusical) {
        this.textoMusical = textoMusical;
    }

}
