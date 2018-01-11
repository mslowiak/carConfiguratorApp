package carconf.controller;

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
    private HBox saversHBox;

    @FXML
    private Button pdfSaverButton;

    @FXML
    private Button htmlSaverButton;

    @FXML
    private Button windowSaverButton;

    @FXML
    private Button goBackButton;

    @FXML
    private Button endConfigButton;

    @FXML
    private Label errorLabel;


    @FXML
    void initialize(){

        goBackButton.setOnAction(e -> {

        });

        endConfigButton.setOnAction(e ->{
            if(saver != null) {
                saver.saveCarConfiguration();
            } else {
                errorLabel.setText("Sposób zapisania danych nie został wybrany");
            }
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

//    public void displayOptionForSavingConfiguration(){
//    }
}
