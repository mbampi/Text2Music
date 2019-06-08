import org.jfugue.pattern.Pattern;

public class Tradutor {

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

        this.volumeAtual = Volume.VOLUME_DEFAULT;
        inicioMusica = Volume.getVolume(this.volumeAtual) + " ";

        this.instrumentoAtual = musica.getInstrumento();
        inicioMusica += Instrumentos.getInstrumentoCode(this.instrumentoAtual) + " ";

        inicioMusica += Ritmo.getBPM(musica.getBpm()) + " ";

        return inicioMusica;
    }

    private String traduzComando(char c){
        if(Nota.isNota(c))
            return nota.getNota(c);

        else if(c == ' ')
            return Volume.dobraVolume(this.volumeAtual);

        else if(c == '!') {
            this.instrumentoAtual = Instrumentos.HARPISCHORD;
            return Instrumentos.getInstrumentoCode(this.instrumentoAtual);
        }
        else if(isVogal(c) && !Nota.isNota(c))
            return Volume.aumentaVolume10porCento(this.volumeAtual);

        else if(Character.isDigit(c)) {
            this.instrumentoAtual = Instrumentos.trocaInstrumento(this.instrumentoAtual, (int) c);
            return Instrumentos.getInstrumentoCode(this.instrumentoAtual);
        }

        else if(c == '?' || c == '.')
            nota.aumentaOitava();

        else if(c == '\n') {
            this.instrumentoAtual = Instrumentos.TUBULAR_BELLS;
            return Instrumentos.getInstrumentoCode(this.instrumentoAtual);
        }

        else if(c == ';') {
            this.instrumentoAtual = Instrumentos.PAN_FLUTE;
            return Instrumentos.getInstrumentoCode(this.instrumentoAtual);
        }

        else if(c == ',') {
            this.instrumentoAtual = Instrumentos.CHURCH_ORGAN;
            return Instrumentos.getInstrumentoCode(this.instrumentoAtual);
        }

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

}
