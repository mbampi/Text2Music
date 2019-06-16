package View;

import Code.Ritmo;
import javafx.scene.control.Alert;

class Erros {
    final static String TITULO_TEXTO_MUSICAL_VAZIO = "Texto Musical Vazio";
    final static String MENSAGEM_TEXTO_MUSICAL_VAZIO = "Carregue/escreva o texto musical para poder continuar";

    final static String TITULO_RITMO_VAZIO = "Ritmo Invalido";
    final static String MENSAGEM_RITMO_VAZIO = "Ritmo deve estar entre " + Ritmo.MIN_BPM + " e " + Ritmo.MAX_BPM +".";

    final static String TITULO_INSTRUMENTO_VAZIO = "Instrumento Não Selecionado";
    final static String MENSAGEM_INSTRUMENTO_VAZIO = "Selecione o instrumento para poder continuar";

    static void exibeMensagemErro(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
