package carconf.scene;


import carconf.controller.ChooseEngineSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ChooseEngineScene {
    private Scene scene;
    private FXMLLoader loader;
    private ChooseEngineSceneController engineSceneController;

    public ChooseEngineScene(Scene scene) {
        this.scene = scene;
        setScene();
        setController();
    }

    private void setScene() {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/choose_engine_scene.fxml"));

        try {
            VBox vBox = loader.load();
            scene.setRoot(vBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setController() {
        engineSceneController = loader.getController();
        engineSceneController.setScene(scene);
    }

    public ChooseEngineSceneController getEngineSceneController() {
        return engineSceneController;
    }
}
