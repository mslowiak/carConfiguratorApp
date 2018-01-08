package carconf.scene;

import carconf.controller.ChooseModelSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ChooseModelScene {
    private Scene scene;
    private FXMLLoader loader;
    private ChooseModelSceneController carSceneController;

    public ChooseModelScene(Scene scene) {
        this.scene = scene;
        setScene();
        setController();
        carSceneController.displayCars();
    }

    private void setScene() {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/choose_model_scene.fxml"));

        try {
            VBox vBox = loader.load();
            scene.setRoot(vBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setController() {
        carSceneController = loader.getController();
        carSceneController.setScene(scene);
    }

}
