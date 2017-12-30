package carconf.scene;

import carconf.controller.ChooseEquipmentElementsSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ChooseEquipmentElementsScene {
    private Scene scene;
    private FXMLLoader loader;
    private ChooseEquipmentElementsSceneController chooseEquipmentElementsSceneController;

    public ChooseEquipmentElementsScene(Scene scene){
        this.scene = scene;
        setScene();
        setController();
    }

    private void setController() {
        chooseEquipmentElementsSceneController = loader.getController();
        chooseEquipmentElementsSceneController.setScene(scene);
    }

    private void setScene() {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/choose_equipment_elements_scene.fxml"));

        try {
            VBox vBox = loader.load();
            scene.setRoot(vBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ChooseEquipmentElementsSceneController getChooseEquipmentElementsSceneController() {
        return chooseEquipmentElementsSceneController;
    }
}
