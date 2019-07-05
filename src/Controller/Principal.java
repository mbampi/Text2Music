package Controller;

import Model.Instrumentos;
import Model.Musica;
import Model.Ritmo;
import View.Avisos;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Principal extends Application implements Initializable {

    @FXML
    private ComboBox<String> instrumentosDropdown;

    @FXML
    private TextArea textoMusicalEntrada;

    @FXML
    private TextField ritmoEntrada;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../View/InterfaceGrafica.fxml"));
        primaryStage.setTitle("Gerador de Musica");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregaDropdown();
        limitaEntradaRitmo();
    }

    private void limitaEntradaRitmo(){
        ritmoEntrada.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                ritmoEntrada.setText(newValue.replaceAll("[^\\d]", ""));
        });
    }

    private void carregaDropdown(){
        ObservableList<String> obsInstrumentos = FXCollections.observableArrayList(Instrumentos.listaInstrumentos);
        instrumentosDropdown.setItems(obsInstrumentos);
    }

    @FXML
    void carregaMusica(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Carregar Musica");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showOpenDialog(null);
        if(file != null)
            textoMusicalEntrada.setText(textoMusicalEntrada.getText() + leArquivo(file));
    }

    private String leArquivo(File file){
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = bufferedReader.readLine()) != null)
                stringBuffer.append(text);

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado");
        } catch (IOException ex) {
            System.out.println("IO Exception");
        } finally {
            try{
                bufferedReader.close();
            } catch (IOException ex) {
                System.out.println("Erro em bufferedReader.close()");
            }
        }
        return stringBuffer.toString();
    }

    @FXML
    void tocaMusica(ActionEvent event){
        if(inputCorreto()) {
            System.out.println("Tocar Pressed");

            Musica musica = geraMusica();
            Pattern padraoMusical = musica.getMusicPattern();
            System.out.println(padraoMusical.toString());

            Player tocador = new Player();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(Avisos.TITULO_REPRODUZINDO_MUSICA);
            alert.show();
            tocador.play(padraoMusical);
            alert.close();
        }
    }

    @FXML
    void botaoSalvarPressionado(ActionEvent event) {
        System.out.println("Salvar MIDI");
        if (inputCorreto()) {
            Musica musica = geraMusica();
            Pattern padraoMusical = musica.getMusicPattern();
            System.out.println(padraoMusical.toString());

            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("MIDI files", "*.mid");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(null);
            System.out.println(file.toString());

            try {
                MidiFileManager.savePatternToMidi(padraoMusical, file);
            } catch (IOException ex) {
                System.out.println("IO Exception");
            }
        }
    }

    private Musica geraMusica(){
        String textoMusical = textoMusicalEntrada.getText();
        int ritmo = Integer.valueOf(ritmoEntrada.getText());
        String intrumentoSelecionado = instrumentosDropdown.getValue();
        int instrumento = Instrumentos.listaInstrumentos.indexOf(intrumentoSelecionado);

        return new Musica(textoMusical, instrumento, ritmo);
    }

    private Boolean inputCorreto(){
        if(!textoMusicalCorreto())
            Avisos.exibeMensagemErro(Avisos.TITULO_TEXTO_MUSICAL_VAZIO, Avisos.MENSAGEM_TEXTO_MUSICAL_VAZIO);
        else if(!ritmoCorreto())
            Avisos.exibeMensagemErro(Avisos.TITULO_RITMO_VAZIO, Avisos.MENSAGEM_RITMO_VAZIO);
        else if(!instrumentoCorreto())
            Avisos.exibeMensagemErro(Avisos.TITULO_INSTRUMENTO_VAZIO, Avisos.MENSAGEM_INSTRUMENTO_VAZIO);
        else return true;
        return false;
    }

    private Boolean textoMusicalCorreto(){
        return !textoMusicalEntrada.getText().isEmpty();
    }

    private Boolean ritmoCorreto(){
        return !ritmoEntrada.getText().isEmpty() && Ritmo.ritmoValido(Integer.valueOf(ritmoEntrada.getText()));
    }

    private Boolean instrumentoCorreto(){
        return !instrumentosDropdown.getSelectionModel().isEmpty();
    }

}
