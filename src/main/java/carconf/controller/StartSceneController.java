package carconf.controller;

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
            System.out.println("Chce zaczac tworzyc samochodzik");
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
