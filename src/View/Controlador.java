package View;

import Code.Instrumentos;
import Code.Musica;
import Code.Ritmo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controlador extends Application implements Initializable {

    @FXML
    private ComboBox<String> instrumentosDropdown;
    @FXML
    private TextArea textoMusicalInput;
    @FXML
    private TextField ritmoInput;


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/InterfaceGrafica.fxml"));
        primaryStage.setTitle("Text2Music");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregaDropdown();
        limitaEntradaRitmo();
    }

    private void limitaEntradaRitmo(){
        ritmoInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                ritmoInput.setText(newValue.replaceAll("[^\\d]", ""));
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
            textoMusicalInput.setText(textoMusicalInput.getText() + readFile(file));
    }

    private String readFile(File file){
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
            tocador.play(padraoMusical);
        }
    }

    @FXML
    void salvaMIDI(ActionEvent event) {
        System.out.println("Salvar MIDI");

        if(inputCorreto()) {
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
        String textoMusical = textoMusicalInput.getText();
        int ritmo = Integer.valueOf(ritmoInput.getText());
        String intrumentoSelecionado = instrumentosDropdown.getValue();
        int instrumento = Instrumentos.listaInstrumentos.indexOf(intrumentoSelecionado);

        return new Musica(textoMusical, instrumento, ritmo);
    }


    private Boolean inputCorreto(){
        if(!textoMusicalCorreto())
            Erros.exibeMensagemErro(Erros.TITULO_TEXTO_MUSICAL_VAZIO, Erros.MENSAGEM_TEXTO_MUSICAL_VAZIO);
        else if(!ritmoCorreto())
            Erros.exibeMensagemErro(Erros.TITULO_RITMO_VAZIO, Erros.MENSAGEM_RITMO_VAZIO);
        else if(!intrumentoCorreto())
            Erros.exibeMensagemErro(Erros.TITULO_INSTRUMENTO_VAZIO, Erros.MENSAGEM_INSTRUMENTO_VAZIO);
        else return true;
        return false;
    }

    private Boolean textoMusicalCorreto(){
        return !textoMusicalInput.getText().isEmpty();
    }

    private Boolean ritmoCorreto(){
        return !ritmoInput.getText().isEmpty() && Ritmo.ritmoValido(Integer.valueOf(ritmoInput.getText()));
    }

    private Boolean intrumentoCorreto(){
        return !instrumentosDropdown.getSelectionModel().isEmpty();
    }

}

