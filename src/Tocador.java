import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class Tocador {

    public static void toca(Musica musica){
        Player player = new Player();
        Pattern pattern = musica.getMusicPattern();
        player.play(pattern);
    }

}
