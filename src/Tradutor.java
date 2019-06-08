import org.jfugue.pattern.Pattern;

public class Tradutor {

    private static final int MAX_VOLUME = 16383;
    private static final int MIN_VOLUME = 0;
    private static final int MAX_BPM = 220;
    private static final int MIN_BPM = 40;
    private static final int VOLUME_DEFAULT = 60; //TODO Volume default

    private char ultimoComando;
    private Nota nota;
    private int instrumentoAtual;
    private int volumeAtual;

    public Pattern traduzMusica(Musica musica)
    {
        String musicaTraduzida;
        musicaTraduzida = inicializaMusica(musica);

        this.nota = new Nota();

        for (int i=0; i<musica.getTextoMusical().length(); i++)
        {
            char c = musica.getTextoMusical().charAt(i);
            musicaTraduzida += this.traduzComando(c) + ' ';
        }

        return new Pattern(musicaTraduzida);
    }

    private String inicializaMusica(Musica musica)
    {
        String inicioMusica;

        this.volumeAtual = VOLUME_DEFAULT;
        inicioMusica = this.getVolume(this.volumeAtual) + " ";

        this.instrumentoAtual = musica.getInstrumento();
        inicioMusica += Instrumentos.getInstrumentoCode(this.instrumentoAtual) + " ";

        inicioMusica += this.getBPM(musica.getBpm()) + " ";

        return inicioMusica;
    }

    private String traduzComando(char c){
        if(Nota.isNota(c))
            return nota.getNota(c);

        else if(c == ' ')
            return dobraVolume();

        else if(c == '!')
            return Instrumentos.getInstrumentoCode(Instrumentos.HARPISCHORD);

        else if(isVogal(c) && !Nota.isNota(c))
            return aumentaVolume10porCento(this.volumeAtual);

        else if(Character.isDigit(c))
            return trocaInstrumento((int)c);

        else if(c == '?' || c == '.')
            nota.aumentaOitava();

        else if(c == '\n')
                return Instrumentos.getInstrumentoCode(Instrumentos.TUBULAR_BELLS);

        else if(c == ';')
                return Instrumentos.getInstrumentoCode(Instrumentos.PAN_FLUTE);

        else if(c == ',')
                return Instrumentos.getInstrumentoCode(Instrumentos.CHURCH_ORGAN);

        else{ //if(isConsoante(c) && !Nota.isNota(c))
            if(Nota.isNota(ultimoComando))
                return nota.repeteNota();
            return getPausa();
        }
        return "";
    }


    private String getPausa() {
        return "R";
    }

    private boolean isVogal(char c) {
        c = Character.toUpperCase(c);
        return (c == 'A'  || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    private boolean isConsoante(char c) {
        return !isVogal(c);
    }


    // BPM (RITMO)
    public String getBPM(int bpm){
        if(!bpmIsValid(bpm))
            return "";
        return "T" + bpm;
    }

    private boolean bpmIsValid(int bpm){
        return (bpm >= MIN_BPM && bpm <= MAX_BPM);
    }


    // Volume

    public String aumentaVolume10porCento(int volumeAtual) {
        return getVolume((int)Math.round((float)volumeAtual * 1.1));
    }

    public String dobraVolume(){
        return getVolume(volumeAtual*2);
    }

    public String getVolume(int volume){
        if(!volumeIsValid(volume))
            return "";
        return "X[Volume]="+volume;
    }

    private boolean volumeIsValid(int volume){
        return (volume >= MIN_VOLUME && volume <= MAX_VOLUME);
    }


    // Instrumento

    public String trocaInstrumento(int digito){
        return Instrumentos.getInstrumentoCode(instrumentoAtual + digito);
    }

}
