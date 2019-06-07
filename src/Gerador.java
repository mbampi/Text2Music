public class Gerador {

    public static final int MAX_VOLUME = 16383;
    public static final int MIN_VOLUME = 0;
    public static final int MAX_TEMPO = 220;
    public static final int MIN_TEMPO = 40;
    public static final int MAX_PITCH = 16383;
    public static final int MIN_PITCH = 0;
    public static final int MAX_INSTRUMENTO = 127;
    public static final int MIN_INSTRUMENTO = 0;



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

    public String dobraVolume(int volumeAtual){
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
    public String trocaInstrumento(int instrumentoAtual, int digito){
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
