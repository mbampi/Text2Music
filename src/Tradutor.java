import org.jfugue.pattern.Pattern;

public class Tradutor {

    private static final int MAX_VOLUME = 16383;
    private static final int MIN_VOLUME = 0;
    private static final int MAX_TEMPO = 220;
    private static final int MIN_TEMPO = 40;
    private static final int MAX_PITCH = 16383;
    private static final int MIN_PITCH = 0;
    private static final int MAX_INSTRUMENTO = 127;
    private static final int MIN_INSTRUMENTO = 0;
    private static final int VOLUME_DEFAULT = 60; //TODO Volume default

    private char ultimoComando;
    private int ultimaNota;
    private int instrumentoAtual;
    private int volumeAtual;

    public Pattern traduzMusica(Musica musica)
    {
        String musicaTraduzida;

        musicaTraduzida = inicializaMusica(musica);

        for (int i=0; i<musica.getTextoMusical().length(); i++)
        {
            char c = musica.getTextoMusical().charAt(i);
            musicaTraduzida += this.traduzComando(c);
        }
    }

    private String inicializaMusica(Musica musica)
    {
        String inicioMusica;
        volumeAtual = VOLUME_DEFAULT;
        instrumentoAtual = musica.getInstrumento();
        inicioMusica = this.getTempo(musica.getBpm()) + " ";
        inicioMusica += this.getInstrumento(musica.getInstrumento()) + " ";
        inicioMusica += this.getVolume(volumeAtual) + " ";
        // TODO inicioMusica = getRitmo

        return inicioMusica;
    }


    private String traduzComando(char c){
        switch (c){
            case isNota(c):
                return "" + c;

            case ' ':
                return dobraVolume();

            case '!':
                return getInstrumento(Instrumentos.HARPISCHORD);

            case isVogal(c) && !isNota(c):
                return aumentaVolume10porCento();

            case Character.isDigit(c):
                trocaInstrumento((int)c);

            case '?':
            case '.':
                if(podeAumentarOitava())
                    return aumentaOitava();
                else
                    return getOitavaDefault();

            case '\n':
                return getInstrumento(Instrumentos.TUBULAR_BELLS);

            case ';':
                return getInstrumento(Instrumentos.PAN_FLUTE);

            case ',':
                return getInstrumento(Instrumentos.CHURCH_ORGAN);

            case (isConsoante(c) && !isNota(c)):
            default:
                if(isNota(ultimoComando))
                    return repeteNota();
                return getPausa();
        }
    }

    private String getPausa() {
        return "R";
    }

    private String repeteNota() {
        if(isNota(ultimoComando))
            return ultimoComando+"";
    }

    private boolean isVogal(char c)
    {
        c = Character.toUpperCase(c);
        return (c == 'A'  || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    private boolean isConsoante(char c)
    {
        return !isVogal(c);
    }

    public boolean isNota(char comandoAnterior)
    {
        return (c == 'A'  || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' || c == 'G');
    }


    // Tempo
    public String getTempo(int tempo){
        if(!tempoIsValid(tempo))
            return "";
        return "T"+tempo;
    }

    private boolean tempoIsValid(int tempo){
        return (tempo >= MIN_TEMPO && tempo <= MAX_TEMPO);
    }


    // Volume
    public String aumentaVolume10porCento(int volumeAtual){
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


    // Pitch
    public String getPitch(int pitch){
        if(!volumeIsValid(pitch))
            return "";
        return "&"+pitch;
    }

    private boolean pitchIsValid(int pitch){
        return (pitch >= MIN_PITCH && pitch <= MAX_PITCH);
    }


    // Instrumento
    public String trocaInstrumento(int digito){
        return getInstrumento(instrumentoAtual + digito);
    }

    public String getInstrumento(int instrumento){
        if(!instrumentoIsValid(instrumento))
            return "";
        return "I"+instrumento;
    }

    private boolean instrumentoIsValid(int instrumento){
        return (instrumento >= MIN_INSTRUMENTO && instrumento <= MAX_INSTRUMENTO);
    }
}
