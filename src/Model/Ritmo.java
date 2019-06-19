package Model;

public class Ritmo {

    public static final int MAX_BPM = 220;
    public static final int MIN_BPM = 40;

    static String getRitmoToken(int bpm){
        if(ritmoValido(bpm))
            return "T" + bpm;
        return "";
    }

    public static boolean ritmoValido(int bpm){
        return (bpm >= MIN_BPM && bpm <= MAX_BPM);
    }

}
