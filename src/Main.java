
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;


public class Main {

    public static void main(String[] args) {
        System.out.println("Java Text2Music!");

        Player player = new Player();
        Pattern pattern = new Pattern("C D E F G A B");
        player.play(pattern);
    }


}
