package carconf.scene;

import carconf.controller.ChooseEquipmentLevelSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ChooseEquipmentLevelScene {
    private Scene scene;
    private FXMLLoader loader;
    private ChooseEquipmentLevelSceneController equipmentLevelSceneController;

    public ChooseEquipmentLevelScene(Scene scene) {
        this.scene = scene;
        setScene();
        setController();
        equipmentLevelSceneController.displayEquipmentLevelScene();
    }


    private void setScene() {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/choose_equipment_level_scene.fxml"));

        try {
            VBox vBox = loader.load();
            scene.setRoot(vBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setController() {
        equipmentLevelSceneController = loader.getController();
        equipmentLevelSceneController.setScene(scene);
    }

    public ChooseEquipmentLevelSceneController getEquipmentLevelSceneController() {
        return equipmentLevelSceneController;
    }

    public void setEquipmentLevelSceneController(ChooseEquipmentLevelSceneController equipmentLevelSceneController) {
        this.equipmentLevelSceneController = equipmentLevelSceneController;
    }
}
