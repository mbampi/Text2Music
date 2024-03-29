package Model;

class Volume {

    private static final int DOIS = 2;
    private static final float DEZ_PORCENTO = 1.1f;

    private static final int MAX_VOLUME = 16383;
    private static final int MIN_VOLUME = 0;
    static final int VOLUME_DEFAULT = 10000;

    static int aumentaDezPorCento(int volumeAtual) {
        if(!volumeIsValid((int)(volumeAtual * DEZ_PORCENTO)))
            return volumeAtual;
        return (int)(volumeAtual * DEZ_PORCENTO);
    }

    static int dobra(int volumeAtual){
        if (!volumeIsValid(volumeAtual * DOIS))
            return volumeAtual;
        return (volumeAtual * DOIS);
    }

    static String getVolumeToken(int volume){
        if(!volumeIsValid(volume))
            return "";
        return "X[Volume]="+volume;
    }

    private static boolean volumeIsValid(int volume){
        return (volume >= MIN_VOLUME && volume <= MAX_VOLUME);
    }

}
