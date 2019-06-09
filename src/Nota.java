
class Nota {

    private static final int MAX_OITAVA = 10;
    private static final int MIN_OITAVA = 0;
    private static final int OITAVA_DEFAULT = 5;

    private int oitava;
    private char ultimaNota;

    String getNota(char nota){
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
        return this.oitava + 1 <= MAX_OITAVA;
    }

}
