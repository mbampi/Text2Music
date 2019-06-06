import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class Tocador {

    public void toca(Musica musica){
        Player player = new Player();
        Pattern padrao = musica.getPadraoMusical();
        player.play(padrao);
    }

}