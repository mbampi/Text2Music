
public class Nota {

    private static final int MAX_OITAVA = 10;
    private static final int MIN_OITAVA = 0;
    private static final int OITAVA_DEFAULT = 5;

    private int oitava;
    private char ultimaNota;

    public String repeteNota(){
        return ultimaNota + "" + oitava;
    }

    public String getNota(char c){
        return c + "" + oitava;
    }

    private boolean podeAumentarOitava(){
        return this.oitava + 1 <= MAX_OITAVA;
    }

    private boolean podeDiminuirOitava(){
        return oitava  >= MIN_OITAVA;
    }

    public void aumentaOitava() {
        if(podeAumentarOitava())
            this.oitava++;
        else
            this.oitava = OITAVA_DEFAULT;
    }

    public static boolean isNota(char c) {
        return (c == 'A'  || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' || c == 'G');
    }

}
