package Model;

import org.jfugue.theory.Note;

class Tradutor {

    private Comando comando = new Comando();
    private Nota nota = new Nota();
    private int instrumentoAtual;
    private int volumeAtual;

    String traduzMusica(Musica musica) {
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
        inicioMusica = Volume.getVolumeToken(this.volumeAtual) + " ";

        this.instrumentoAtual = musica.getInstrumento();
        inicioMusica += Instrumentos.getInstrumentoToken(this.instrumentoAtual) + " ";

        inicioMusica += Ritmo.getRitmoToken(musica.getBpm()) + " ";

        return inicioMusica;
    }

    private String traduzComando(Comando comando){

        if(comando.comandoIsNota())
            return nota.getNotaToken(comando.getComando());

        else if(comando.getComando() == ' ') {
            this.volumeAtual = Volume.dobra(this.volumeAtual);
            return Volume.getVolumeToken(this.volumeAtual);
        }

        else if(comando.getComando() == '!') {
            this.instrumentoAtual = Instrumentos.HARPISCHORD;
            return Instrumentos.getInstrumentoToken(this.instrumentoAtual);
        }

        else if(comando.isOUI()) {
            this.volumeAtual = Volume.aumentaDezPorCento(this.volumeAtual);
            return Volume.getVolumeToken(this.volumeAtual);
        }

        else if(comando.isDigito()) {
            this.instrumentoAtual = Instrumentos.trocaInstrumento(this.instrumentoAtual, comando.getComandoDigito());
            return Instrumentos.getInstrumentoToken(this.instrumentoAtual);
        }

        else if(comando.getComando() == '?' || comando.getComando() == '.') {
            nota.aumentaOitava();
            return "";
        }
        else if(comando.getComando() == '\n') {
            this.instrumentoAtual = Instrumentos.TUBULAR_BELLS;
            return Instrumentos.getInstrumentoToken(this.instrumentoAtual);
        }

        else if(comando.getComando() == ';') {
            this.instrumentoAtual = Instrumentos.PAN_FLUTE;
            return Instrumentos.getInstrumentoToken(this.instrumentoAtual);
        }

        else if(comando.getComando() == ',') {
            this.instrumentoAtual = Instrumentos.CHURCH_ORGAN;
            return Instrumentos.getInstrumentoToken(this.instrumentoAtual);
        }

        else{
            if(comando.ultimoComandoIsNota())
                return nota.getNotaToken(comando.getUltimoComando());
            return String.valueOf(Note.REST);
        }
    }

}
