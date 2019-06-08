import org.jfugue.pattern.Pattern;

public class Musica {

    private String textoMusical;
    private int instrumento;
    private int ritmo;
    private int bpm;

    public Musica(String textoMusical, int instrumento, int ritmo, int bpm) {
        this.textoMusical = textoMusical;
        this.instrumento = instrumento;
        this.ritmo = ritmo;
        this.bpm = bpm;
    }

    public Pattern getMusicPattern(){
        return Tradutor.traduzMusica(this);
    }

    public String getTextoMusical() {
        return textoMusical;
    }

    public int getInstrumento() {
        return instrumento;
    }

    public int getRitmo() {
        return ritmo;
    }

    public int getBpm() {
        return bpm;
    }

    public void setTextoMusical(String textoMusical) {
        this.textoMusical = textoMusical;
    }


}
