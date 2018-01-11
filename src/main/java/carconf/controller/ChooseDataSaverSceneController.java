package carconf.controller;

import carconf.savers.PdfFullSaver;
import carconf.savers.PdfSimpleSaver;
import carconf.savers.SaverInterface;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ChooseDataSaverSceneController {
    private Scene scene;
    private SaverInterface saver;
    @FXML
    private Label topLabel;

    @FXML
    private Label priceTextLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private HBox saversHBox;

    @FXML
    private Button pdfFullSaverButton;

    @FXML
    private Button pdfSimpleSaverButton;


    @FXML
    private Button goBackButton;



    @FXML
    void initialize(){

        goBackButton.setOnAction(e -> {

        });

        pdfFullSaverButton.setOnAction(e ->{
            saver = new PdfFullSaver();
        });

        pdfSimpleSaverButton.setOnAction(e -> {
            saver = new PdfSimpleSaver();
        } );

        priceLabel.setText("78 000");
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

//    public void displayOptionForSavingConfiguration(){
//    }
}
