public class Ritmo {

    private static final int MAX_BPM = 220;
    private static final int MIN_BPM = 40;

    public static String getBPM(int bpm){
        if(!bpmIsValid(bpm))
            return "";
        return "T" + bpm;
    }

    private static boolean bpmIsValid(int bpm){
        return (bpm >= MIN_BPM && bpm <= MAX_BPM);
    }

}
