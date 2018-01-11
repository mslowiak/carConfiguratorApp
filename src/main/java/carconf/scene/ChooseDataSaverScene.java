package carconf.scene;

import carconf.controller.ChooseDataSaverSceneController;
import carconf.controller.ChooseWheelSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ChooseDataSaverScene {
    private Scene scene;
    private FXMLLoader loader;
    private ChooseDataSaverSceneController chooseDataSaverSceneController;

    public ChooseDataSaverScene(Scene scene) {
        this.scene = scene;
        setScene();
        setController();
//        chooseDataSaverSceneController.displayOptionForSavingConfiguration();
    }

    private void setController() {
        chooseDataSaverSceneController = loader.getController();
        chooseDataSaverSceneController.setScene(scene);
    }

    private void setScene() {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/choose_dataSaver_scene.fxml"));

        try {
            VBox vBox = loader.load();
            scene.setRoot(vBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ChooseDataSaverSceneController getDataSaverSceneController() {
        return chooseDataSaverSceneController;
    }
}
