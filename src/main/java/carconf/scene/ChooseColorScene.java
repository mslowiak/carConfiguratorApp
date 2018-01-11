package carconf.scene;

import carconf.controller.ChooseColorSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ChooseColorScene {
    private Scene scene;
    private FXMLLoader loader;
    private ChooseColorSceneController chooseColorSceneController;

    public ChooseColorScene(Scene scene) {
        this.scene = scene;
        setScene();
        setController();
        chooseColorSceneController.displayColors();
    }

    private void setScene() {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/choose_color_scene.fxml"));

        try {
            VBox vBox = loader.load();
            scene.setRoot(vBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setController() {
        chooseColorSceneController = loader.getController();
        chooseColorSceneController.setScene(scene);
    }

    public ChooseColorSceneController getChooseColorSceneController() {
        return chooseColorSceneController;
    }
}
