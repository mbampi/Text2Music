package View;

import Code.Musica;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import java.io.*;

public class InterfaceGrafica extends Application {

    @FXML
    private ChoiceBox<String> instrumentoDropdown;
    private ObservableList listaInstrumentos = FXCollections.observableArrayList("a");
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
        carregaDropdown();
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

    private void carregaDropdown(){
    }

    @FXML
    void salvarMIDI(ActionEvent event) {
        System.out.println("Salvar MIDI");

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

    @FXML
    void tocaMusica(ActionEvent event){
        System.out.println("Tocar Pressed");

        Musica musica = geraMusica();
        Pattern padraoMusical = musica.getMusicPattern();
        System.out.println(padraoMusical.toString());

        Player tocador = new Player();
        tocador.play(padraoMusical);
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

    private Musica geraMusica(){
        String textoMusical = textoMusicalInput.getText();
        int ritmo = Integer.valueOf(ritmoInput.getText());
        int instrumento = 4;
        return new Musica(textoMusical, instrumento, ritmo);
    }

}

