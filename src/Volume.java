class Volume {

    private static final int DOIS = 2;
    private static final float DEZ_PORCENTO = 1.1f;
    private static final int MAX_VOLUME = 16383;
    private static final int MIN_VOLUME = 0;
    static final int VOLUME_DEFAULT = 60; //TODO volume default


    static int aumentaVolume10porCento(int volume) {
        if(!volumeIsValid((int)(volume * DEZ_PORCENTO)))
            return volume;
        return (int)(volume * DEZ_PORCENTO);
    }

    static int dobraVolume(int volume){
        if(!volumeIsValid((int)(volume * DOIS)))
            return volume;
        return (volume * DOIS);
    }

    static String getVolume(int volume){
        if(!volumeIsValid(volume))
            return "";
        return "X[Volume]="+volume;
    }

    private static boolean volumeIsValid(int volume){
        return (volume >= MIN_VOLUME && volume <= MAX_VOLUME);
    }

}
