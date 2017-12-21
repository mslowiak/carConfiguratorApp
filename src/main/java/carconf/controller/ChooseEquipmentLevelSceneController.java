package carconf.controller;

import carconf.element.EquipmentLevelInfo;
import carconf.entity.EquipmentLevel;
import carconf.service.impl.EquipmentLevelServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.text.DecimalFormat;
import java.util.List;

public class ChooseEquipmentLevelSceneController {

    private Scene scene;
    private int choseModelId;

    @FXML
    private Label topLabel;

    @FXML
    private VBox equipmentLevelsVBox;

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
        for (int i=0; i<equipmentLevelsByModelId.size(); ++i){
            EquipmentLevel e = equipmentLevelsByModelId.get(i);
            equipmentLevelsVBox.getChildren().add(new EquipmentLevelInfo((i+1) + ".", e.getName(), new DecimalFormat("#").format(e.getPrice()) + " PLN"));
        }
    }
}
