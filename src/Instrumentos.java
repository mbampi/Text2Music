
 class Instrumentos {
     private static final int MAX_INSTRUMENTO = 127;
     private static final int MIN_INSTRUMENTO = 0;

     static final byte PIANO = 0;
     static final byte ACOUSTIC_GRAND = 0;
     static final byte BRIGHT_ACOUSTIC = 1;
     static final byte ELECTRIC_GRAND = 2;
     static final byte HONKEY_TONK = 3;
     static final byte ELECTRIC_PIANO = 4;
     static final byte ELECTRIC_PIANO_1 = 4;
     static final byte ELECTRIC_PIANO_2 = 5;
     static final byte HARPISCHORD = 6;
     static final byte CLAVINET = 7;
     static final byte CELESTA = 8;
     static final byte GLOCKENSPIEL = 9;

     static final byte MUSIC_BOX = 10;
     static final byte VIBRAPHONE = 11;
     static final byte MARIMBA = 12;
     static final byte XYLOPHONE = 13;
     static final byte TUBULAR_BELLS = 14;
     static final byte DULCIMER = 15;
     static final byte DRAWBAR_ORGAN = 16;
     static final byte PERCUSSIVE_ORGAN = 17;
     static final byte ROCK_ORGAN = 18;
     static final byte CHURCH_ORGAN = 19;

     static final byte REED_ORGAN = 20;
     static final byte ACCORDIAN = 21;
     static final byte HARMONICA = 22;
     static final byte TANGO_ACCORDIAN = 23;
     static final byte GUITAR = 24;
     static final byte NYLON_STRING_GUITAR = 24;
     static final byte STEEL_STRING_GUITAR = 25;
     static final byte ELECTRIC_JAZZ_GUITAR = 26;
     static final byte ELECTRIC_CLEAN_GUITAR = 27;
     static final byte ELECTRIC_MUTED_GUITAR = 28;
     static final byte OVERDRIVEN_GUITAR = 29;

     static final byte DISTORTION_GUITAR = 30;
     static final byte GUITAR_HARMONICS = 31;
     static final byte ACOUSTIC_BASS = 32;
     static final byte ELECTRIC_BASS_FINGER = 33;
     static final byte ELECTRIC_BASS_PICK = 34;
     static final byte FRETLESS_BASS = 35;
     static final byte SLAP_BASS_1 = 36;
     static final byte SLAP_BASS_2 = 37;
     static final byte SYNTH_BASS_1 = 38;
     static final byte SYNTH_BASS_2 = 39;

     static final byte VIOLIN = 40;
     static final byte VIOLA = 41;
     static final byte CELLO = 42;
     static final byte CONTRABASS = 43;
     static final byte TREMOLO_STRINGS = 44;
     static final byte PIZZICATO_STRINGS = 45;
     static final byte ORCHESTRAL_STRINGS = 46;
     static final byte TIMPANI = 47;
     static final byte STRING_ENSEMBLE_1 = 48;
     static final byte STRING_ENSEMBLE_2 = 49;

     static final byte SYNTH_STRINGS_1 = 50;
     static final byte SYNTH_STRINGS_2 = 51;
     static final byte CHOIR_AAHS = 52;
     static final byte VOICE_OOHS = 53;
     static final byte SYNTH_VOICE = 54;
     static final byte ORCHESTRA_HIT = 55;
     static final byte TRUMPET = 56;
     static final byte TROMBONE = 57;
     static final byte TUBA = 58;
     static final byte MUTED_TRUMPET = 59;

     static final byte FRENCH_HORN = 60;
     static final byte BRASS_SECTION = 61;
     static final byte SYNTHBRASS_1 = 62;
     static final byte SYNTH_BRASS_1 = 62;
     static final byte SYNTHBRASS_2 = 63;
     static final byte SYNTH_BRASS_2 = 63;
     static final byte SOPRANO_SAX = 64;
     static final byte ALTO_SAX = 65;
     static final byte TENOR_SAX = 66;
     static final byte BARITONE_SAX = 67;
     static final byte OBOE = 68;
     static final byte ENGLISH_HORN = 69;

     static final byte BASSOON = 70;
     static final byte CLARINET = 71;
     static final byte PICCOLO = 72;
     static final byte FLUTE = 73;
     static final byte RECORDER = 74;
     static final byte PAN_FLUTE = 75;
     static final byte BLOWN_BOTTLE = 76;
     static final byte SKAKUHACHI = 77;
     static final byte WHISTLE = 78;
     static final byte OCARINA = 79;

     static final byte LEAD_SQUARE = 80;
     static final byte SQUARE = 80;
     static final byte LEAD_SAWTOOTH = 81;
     static final byte SAWTOOTH = 81;
     static final byte LEAD_CALLIOPE = 82;
     static final byte CALLIOPE = 82;
     static final byte LEAD_CHIFF = 83;
     static final byte CHIFF = 83;
     static final byte LEAD_CHARANG = 84;
     static final byte CHARANG = 84;
     static final byte LEAD_VOICE = 85;
     static final byte VOICE = 85;
     static final byte LEAD_FIFTHS = 86;
     static final byte FIFTHS = 86;
     static final byte LEAD_BASSLEAD = 87;
     static final byte BASSLEAD = 87;
     static final byte PAD_NEW_AGE = 88;
     static final byte NEW_AGE = 88;
     static final byte PAD_WARM = 89;
     static final byte WARM = 89;

     static final byte PAD_POLYSYNTH = 90;
     static final byte POLYSYNTH = 90;
     static final byte PAD_CHOIR = 91;
     static final byte CHOIR = 91;
     static final byte PAD_BOWED = 92;
     static final byte BOWED = 92;
     static final byte PAD_METALLIC = 93;
     static final byte METALLIC = 93;
     static final byte PAD_HALO = 94;
     static final byte HALO = 94;
     static final byte PAD_SWEEP = 95;
     static final byte SWEEP = 95;
     static final byte FX_RAIN = 96;
     static final byte RAIN = 96;
     static final byte FX_SOUNDTRACK = 97;
     static final byte SOUNDTRACK = 97;
     static final byte FX_CRYSTAL = 98;
     static final byte CRYSTAL = 98;
     static final byte FX_ATMOSPHERE = 99;
     static final byte ATMOSPHERE = 99;

     static final byte FX_BRIGHTNESS = 100;
     static final byte BRIGHTNESS = 100;
     static final byte FX_GOBLINS = 101;
     static final byte GOBLINS = 101;
     static final byte FX_ECHOES = 102;
     static final byte ECHOES = 102;
     static final byte FX_SCI = 103;
     static final byte SCI = 103;
     static final byte SITAR = 104;
     static final byte BANJO = 105;
     static final byte SHAMISEN = 106;
     static final byte KOTO = 107;
     static final byte KALIMBA = 108;
     static final byte BAGPIPE = 109;

     static final byte FIDDLE = 110;
     static final byte SHANAI = 111;
     static final byte TINKLE_BELL = 112;
     static final byte AGOGO = 113;
     static final byte STEEL_DRUMS = 114;
     static final byte WOODBLOCK = 115;
     static final byte TAIKO_DRUM = 116;
     static final byte MELODIC_TOM = 117;
     static final byte SYNTH_DRUM = 118;
     static final byte REVERSE_CYMBAL = 119;

     static final byte GUITAR_FRET_NOISE = 120;
     static final byte BREATH_NOISE = 121;
     static final byte SEASHORE = 122;
     static final byte BIRD_TWEET = 123;
     static final byte TELEPHONE_RING = 124;
     static final byte HELICOPTER = 125;
     static final byte APPLAUSE = 126;
     static final byte GUNSHOT = 127;

     static boolean isValidInstrument(int instrument){
         return (instrument >= MIN_INSTRUMENTO && instrument <= MAX_INSTRUMENTO);
     }

     static String getInstrumentoCode(int instrumento){
         if(!isValidInstrument(instrumento))
             return "";
         return "I"+instrumento;
     }

     static int trocaInstrumento(int instrumentoAtual, int digito){
         if(!isValidInstrument(instrumentoAtual + digito))
             return instrumentoAtual;
         return instrumentoAtual+digito;
     }
}

