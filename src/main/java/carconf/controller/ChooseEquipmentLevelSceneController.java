package carconf.controller;

import carconf.service.impl.EquipmentLevelServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ChooseEquipmentLevelSceneController {

    private Scene scene;
    private String choseModelId;

    @FXML
    private Label topLabel;

    @FXML
    private VBox equipmentLevelsVbox;

    @FXML
    private Button goBackButton;

    @FXML
    private Button goNextButton;

    @FXML
    void initialize(){
        goBackButton.setOnAction(e ->{

        });
        goNextButton.setOnAction(e ->{

        });
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setChoseCarModel(String modelId){
        this.choseModelId = modelId;
    }

    public void displayEquipmentLevelScene(){
        EquipmentLevelServiceImpl equipmentLevelService = new EquipmentLevelServiceImpl();
    }
}
