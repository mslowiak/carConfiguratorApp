package carconf.controller;

import carconf.App;
import carconf.car_assembling.car_decorators.EngineCarDecorator;
import carconf.element.EngineInfo;
import carconf.entity.ConfigurationsLevelEngine;
import carconf.entity.Engine;
import carconf.scene.ChooseColorScene;
import carconf.service.impl.ConfigurationsLevelEngineServiceImpl;
import carconf.service.impl.EngineServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.util.List;

public class ChooseEngineSceneController {

    private Scene scene;
    private ToggleGroup radiosGroup;
    private int choseEquipmentLevel;

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

        goBackButton.setOnAction(e -> {

        });

        goNextButton.setOnAction(e -> {
            if(radiosGroup.getSelectedToggle() != null) {
                int engineID = Integer.parseInt(radiosGroup.getSelectedToggle().getUserData().toString());
                ChooseColorScene colorScene = new ChooseColorScene(scene);
                colorScene.getChooseColorSceneController().displayColors();
                EngineServiceImpl engineService = new EngineServiceImpl();
                App.car = new EngineCarDecorator(App.car, engineService.getEngineByEngineId(engineID).get(0));
            }else{
                errorLabel.setText("Silnik nie został wybrany");
            }
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void displayEngines(){
        ConfigurationsLevelEngineServiceImpl configurationsLevelEngineService =
                new ConfigurationsLevelEngineServiceImpl();
        List<ConfigurationsLevelEngine> configurationsByLevelId =
                configurationsLevelEngineService.getConfigurationsByLevelId(choseEquipmentLevel);
        for(int i = 0; i < configurationsByLevelId.size(); ++i){
            Engine engine = configurationsByLevelId.get(i).getEngine();
            EngineInfo engineInfo = new EngineInfo((i + 1) + ".", engine);
            engineInfo.getRadioButton().setUserData(engine.getEngineId());
            engineInfo.getRadioButton().setToggleGroup(radiosGroup);
            equipmentLevelsVBox.getChildren().add(engineInfo);
        }
    }

    public void setChoseEquipmentLevel(int choseEquipmentLevel) {
        this.choseEquipmentLevel = choseEquipmentLevel;
        displayEngines();
    }
}
