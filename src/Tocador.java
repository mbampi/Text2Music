import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class Tocador {

    public static void toca(Pattern padrao){
        Player player = new Player();
        player.play(padrao);
    }

}
