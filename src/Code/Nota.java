package Code;

import org.jfugue.theory.Note;

class Nota {

    private static final int OITAVA_DEFAULT = 5;

    private int oitava;
    private char ultimaNota;

    String getNotaToken(char nota){
        this.ultimaNota = nota;
        return nota + "" + oitava;
    }

    String repeteNota(){
        return ultimaNota + "" + oitava;
    }

    void aumentaOitava() {
        if(podeAumentarOitava())
            this.oitava++;
        else
            this.oitava = OITAVA_DEFAULT;
    }

    private boolean podeAumentarOitava(){
        return this.oitava + 1 <= Note.MAX_OCTAVE;
    }
}
