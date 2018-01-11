package carconf.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class ChooseDataSaverSceneController {
    private Scene scene;
    private ToggleGroup radiosGroup;

    @FXML
    private Label topLabel;

    @FXML
    private HBox saversHBox;

    @FXML
    private Button firstTypeButton;

    @FXML
    private Button secondTypeButton;

    @FXML
    private Button thirdTypeButton;

    @FXML
    private Button goBackButton;

    @FXML
    private Button endConfigButton;

    @FXML
    private Label errorLabel;


    @FXML
    void initialize(){
        radiosGroup = new ToggleGroup();


        goBackButton.setOnAction(e -> {

        });

        endConfigButton.setOnAction(e ->{
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void displayOptionForSavingConfiguration(){
    }
}
