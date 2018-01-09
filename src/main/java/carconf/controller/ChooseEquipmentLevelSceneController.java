package carconf.controller;

import carconf.App;
import carconf.car_assembling.car_decorators.EquipmentLevelCarDecorator;
import carconf.element.EquipmentLevelInfo;
import carconf.entity.EquipmentLevel;
import carconf.scene.ChooseEngineScene;
import carconf.service.impl.EquipmentLevelServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.text.DecimalFormat;
import java.util.List;

public class ChooseEquipmentLevelSceneController {

    private Scene scene;
    private ToggleGroup radiosGroup;
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
    private Label errorLabel;

    @FXML
    void initialize(){
        radiosGroup = new ToggleGroup();
        goBackButton.setOnAction(e ->{

        });
        goNextButton.setOnAction(e ->{
            if(radiosGroup.getSelectedToggle() != null) {
                int equipmentLevelID = Integer.parseInt(radiosGroup.getSelectedToggle().getUserData().toString());
                ChooseEngineScene chooseEngineScene = new ChooseEngineScene(scene);
                chooseEngineScene
                        .getEngineSceneController()
                        .setChoseEquipmentLevel(equipmentLevelID);
                EquipmentLevelServiceImpl levelService = new EquipmentLevelServiceImpl();
                int modelID = App.car.getCarContent().getModel().getModelId();
                App.car = new EquipmentLevelCarDecorator(App.car,
                        levelService.getEquipmentLevelByEquipmentLevelIdAndModelId(equipmentLevelID, modelID).get(0));
            }else{
                errorLabel.setText("Rodzaj wyposażenia nie został wybrany");
            }
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
            EquipmentLevelInfo equipmentLevelInfo = new EquipmentLevelInfo((i + 1) + ".", e.getName(), new DecimalFormat("#").format(e.getPrice()) + " PLN");
            equipmentLevelInfo.getRadioButton().setUserData(e.getLevelId());
            equipmentLevelInfo.getRadioButton().setToggleGroup(radiosGroup);
            equipmentLevelsVBox.getChildren().add(equipmentLevelInfo);
        }
    }
}
