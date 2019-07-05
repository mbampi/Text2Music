package Model;

import org.jfugue.theory.Note;

class Nota {

    private static final int OITAVA_DEFAULT = 5;

    private int oitava;

    Nota(){
        this.oitava = OITAVA_DEFAULT;
    }

    String getNotaToken(char nota){
        return nota + "" + oitava;
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
