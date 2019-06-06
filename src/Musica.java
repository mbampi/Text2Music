import org.jfugue.pattern.Pattern;

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
    }

    public Pattern getPadraoMusical(){
        Pattern padrao = new Pattern(this.textoMusical);
        return padrao;
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

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public void setRitmo(int ritmo) {
        this.ritmo = ritmo;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }
}
