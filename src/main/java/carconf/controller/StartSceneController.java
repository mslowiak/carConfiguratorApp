package carconf.controller;

import carconf.scene.ChooseCarScene;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StartSceneController {
    private Scene scene;
    @FXML
    private Label welcomeLabel;

    @FXML
    private Button startButton;

    @FXML
    private Label createdByLabel;

    @FXML
    void initialize(){
        startButton.setOnAction(e ->{
            new ChooseCarScene(scene);
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
