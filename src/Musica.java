import org.jfugue.pattern.Pattern;
import org.jfugue.theory.Note;

public class Musica {

    private String textoMusical;
    private Instrumento instrumento;
    private int ritmo;
    private int bpm;

    public Musica(String textoMusical, Instrumento instrumento, int ritmo, int bpm) {
        this.textoMusical = textoMusical;
        this.instrumento = instrumento;
        this.ritmo = ritmo;
        this.bpm = bpm;
        Note.
    }

    public Pattern getPattern(){
        return new Pattern(this.textoMusical);
    }

    public String getTextoMusical() {
        return textoMusical;
    }

    public Instrumento getInstrumento() {
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
