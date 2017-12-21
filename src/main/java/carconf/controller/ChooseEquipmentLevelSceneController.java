package carconf.controller;

import carconf.entity.EquipmentLevel;
import carconf.service.impl.EquipmentLevelServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

public class ChooseEquipmentLevelSceneController {

    private Scene scene;
    private int choseModelId;

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

    public void setChoseCarModel(int modelId){
        this.choseModelId = modelId;
        displayEquipmentLevelScene();
    }

    public void displayEquipmentLevelScene(){
        EquipmentLevelServiceImpl equipmentLevelService = new EquipmentLevelServiceImpl();
        List<EquipmentLevel> equipmentLevelsByModelId = equipmentLevelService.getEquipmentLevelsByModelId(choseModelId);
        for (EquipmentLevel e : equipmentLevelsByModelId){
            System.out.println( e.getName());
        }
    }
}
