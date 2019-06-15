package Code;

public class Volume {

    private static final int DOIS = 2;
    private static final float DEZ_PORCENTO = 1.1f;

    private static final int MAX_VOLUME = 16383;
    private static final int MIN_VOLUME = 0;
    static final int VOLUME_DEFAULT = 10000;

    public static int aumentaVolume10porCento(int volumeAtual) {
        if(!volumeIsValid((int)(volumeAtual * DEZ_PORCENTO)))
            return volumeAtual;
        return (int)(volumeAtual * DEZ_PORCENTO);
    }

    public static int dobraVolume(int volumeAtual){
        if (!volumeIsValid((int) (volumeAtual * DOIS)))
            return volumeAtual;
        return (volumeAtual * DOIS);
    }

    public static String getVolume(int volume){
        if(!volumeIsValid(volume))
            return "";
        return "X[Volume]="+volume;
    }

    private static boolean volumeIsValid(int volume){
        return (volume >= MIN_VOLUME && volume <= MAX_VOLUME);
    }

}
