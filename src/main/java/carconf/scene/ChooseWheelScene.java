package carconf.scene;

import carconf.controller.ChooseWheelSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ChooseWheelScene {
    private Scene scene;
    private FXMLLoader loader;
    private ChooseWheelSceneController chooseWheelSceneController;

    public ChooseWheelScene(Scene scene) {
        this.scene = scene;
        setScene();
        setController();
        chooseWheelSceneController.displayWheels();
    }

    private void setController() {
        chooseWheelSceneController = loader.getController();
        chooseWheelSceneController.setScene(scene);
    }

    private void setScene() {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/choose_wheel_scene.fxml"));

        try {
            VBox vBox = loader.load();
            scene.setRoot(vBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ChooseWheelSceneController getChooseWheelSceneController() {
        return chooseWheelSceneController;
    }
}
