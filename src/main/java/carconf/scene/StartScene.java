package carconf.scene;

import carconf.controller.StartSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class StartScene {
    private Scene scene;
    private FXMLLoader loader;

    public StartScene(Scene scene) {
        this.scene = scene;
        setScene();
        setController();
    }

    private void setScene() {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/start_scene.fxml"));

        try {
            VBox vBox = loader.load();
            scene.setRoot(vBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setController() {
        StartSceneController startSceneController = loader.getController();
        startSceneController.setScene(scene);
    }

}
