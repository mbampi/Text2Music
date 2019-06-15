package Code;

import org.jfugue.theory.Note;

public class Tradutor {

    private Comando comando = new Comando();
    private Nota nota = new Nota();
    private int instrumentoAtual;
    private int volumeAtual;

    public String traduzMusica(Musica musica) {
        StringBuilder musicaTraduzida = new StringBuilder(inicializaMusica(musica));

        for (int i=0; i<musica.getTextoMusical().length(); i++)
        {
            comando.setComando(musica.getTextoMusical().charAt(i));
            musicaTraduzida.append(this.traduzComando(comando)).append(' ');
        }

        return musicaTraduzida.toString();
    }

    private String inicializaMusica(Musica musica) {
        String inicioMusica;

        this.volumeAtual = Volume.VOLUME_DEFAULT;
        inicioMusica = Volume.getVolume(this.volumeAtual) + " ";

        this.instrumentoAtual = musica.getInstrumento();
        inicioMusica += Instrumentos.getInstrumentoCode(this.instrumentoAtual) + " ";

        inicioMusica += Ritmo.getBPM(musica.getBpm()) + " ";

        return inicioMusica;
    }

    private String traduzComando(Comando comando){

        if(comando.comandoIsNota())
            return nota.getNota(comando.getComando());

        else if(comando.getComando() == ' ') {
            this.volumeAtual = Volume.dobraVolume(this.volumeAtual);
            return Volume.getVolume(this.volumeAtual);
        }

        else if(comando.getComando() == '!') {
            this.instrumentoAtual = Instrumentos.HARPISCHORD;
            return Instrumentos.getInstrumentoCode(this.instrumentoAtual);
        }

        else if(comando.isOUI()) {
            this.volumeAtual = Volume.aumentaVolume10porCento(this.volumeAtual);
            return Volume.getVolume(this.volumeAtual);
        }

        else if(comando.isDigito()) {
            this.instrumentoAtual = Instrumentos.trocaInstrumento(this.instrumentoAtual, (int)comando.getComando());
            return Instrumentos.getInstrumentoCode(this.instrumentoAtual);
        }

        else if(comando.getComando() == '?' || comando.getComando() == '.') {
            nota.aumentaOitava();
            return "";
        }
        else if(comando.getComando() == '\n') {
            this.instrumentoAtual = Instrumentos.TUBULAR_BELLS;
            return Instrumentos.getInstrumentoCode(this.instrumentoAtual);
        }

        else if(comando.getComando() == ';') {
            this.instrumentoAtual = Instrumentos.PAN_FLUTE;
            return Instrumentos.getInstrumentoCode(this.instrumentoAtual);
        }

        else if(comando.getComando() == ',') {
            this.instrumentoAtual = Instrumentos.CHURCH_ORGAN;
            return Instrumentos.getInstrumentoCode(this.instrumentoAtual);
        }

        else{
            if(comando.ultimoComandoIsNota())
                return nota.repeteNota();
            return String.valueOf(Note.REST);
        }
    }


}
