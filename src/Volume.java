public class Volume {

    private static final int MAX_VOLUME = 16383;
    private static final int MIN_VOLUME = 0;
    public static final int VOLUME_DEFAULT = 60; //TODO Volume default

    public static String aumentaVolume10porCento(int volume) {
        return getVolume((int)Math.round((float)volume * 1.1));
    }

    public static String dobraVolume(int volume){
        return getVolume(volume*2);
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
