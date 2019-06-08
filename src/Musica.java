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
        return tradutor.traduzMusica(this);
    }

    public String getTextoMusical() {
        return textoMusical;
    }

    public int getInstrumento() {
        return instrumento;
    }

    public int getBpm() {
        return bpm;
    }

    public void setTextoMusical(String textoMusical) {
        this.textoMusical = textoMusical;
    }

}
