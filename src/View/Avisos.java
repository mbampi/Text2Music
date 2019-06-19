package View;

import Model.Ritmo;
import javafx.scene.control.Alert;

public class Avisos {
    public static final String TITULO_REPRODUZINDO_MUSICA = "Reproduzindo Musica!";

    public final static String TITULO_TEXTO_MUSICAL_VAZIO = "Texto Musical Vazio";
    public final static String MENSAGEM_TEXTO_MUSICAL_VAZIO = "Carregue/escreva o texto musical para poder continuar";

    public final static String TITULO_RITMO_VAZIO = "Ritmo Invalido";
    public final static String MENSAGEM_RITMO_VAZIO = "Ritmo deve estar entre " + Ritmo.MIN_BPM + " e " + Ritmo.MAX_BPM +".";

    public final static String TITULO_INSTRUMENTO_VAZIO = "Instrumento Não Selecionado";
    public final static String MENSAGEM_INSTRUMENTO_VAZIO = "Selecione o instrumento para poder continuar";

    public static void exibeMensagemErro(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
