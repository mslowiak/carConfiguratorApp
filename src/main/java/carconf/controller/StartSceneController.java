package carconf.controller;

import carconf.App;
import carconf.scene.ChooseModelScene;
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
    void initialize() {
        startButton.setOnAction(e -> {
            App.carCaretaker.saveCustomizedCar(App.car);
            new ChooseModelScene(scene);
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
