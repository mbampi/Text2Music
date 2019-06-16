package View;

import javafx.scene.control.Alert;

class Erros {
    final static String TITULO_TEXTO_MUSICAL_VAZIO = "Texto musical vazio";
    final static String MENSAGEM_TEXTO_MUSICAL_VAZIO = "Carregue/escreva o texto musical para poder continuar";

    final static String TITULO_RITMO_VAZIO = "Ritmo Vazio";
    final static String MENSAGEM_RITMO_VAZIO = "Insira o ritmo para poder continuar";

    final static String TITULO_INSTRUMENTO_VAZIO = "Instrumento nao selecionado";
    final static String MENSAGEM_INSTRUMENTO_VAZIO = "Selecione o instrumento para poder continuar";

    static void exibeMensagemErro(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro!");
        alert.setHeaderText(titulo);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
