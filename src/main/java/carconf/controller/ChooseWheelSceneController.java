package carconf.controller;

import carconf.App;
import carconf.element.WheelInfo;
import carconf.entity.Wheel;
import carconf.scene.ChooseEquipmentElementsScene;
import carconf.service.impl.WheelServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

import java.util.List;

public class ChooseWheelSceneController {
    private Scene scene;
    private ToggleGroup toggleGroup;

    @FXML
    private Label topLabel;

    @FXML
    private HBox colorsHBox;

    @FXML
    private Button goBackButton;

    @FXML
    private Button goNextButton;

    @FXML
    void initialize(){
        toggleGroup = new ToggleGroup();

        goBackButton.setOnAction(e -> {

        });

        goNextButton.setOnAction(e ->{
            ChooseEquipmentElementsScene chooseEquipmentElementsScene = new ChooseEquipmentElementsScene(scene);
            chooseEquipmentElementsScene.getChooseEquipmentElementsSceneController().displayElements();
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void displayWheels(){
        WheelServiceImpl wheelService = new WheelServiceImpl();
        List<Wheel> wheelsByLevelId = wheelService.getWheelsByLevelId(App.levelId);
        for(int i = 0; i < wheelsByLevelId.size(); ++i){
            Wheel wheel = wheelsByLevelId.get(i);
            WheelInfo wheelInfo = new WheelInfo(wheel);
            wheelInfo.getRadioButton().setUserData(i);
            wheelInfo.getRadioButton().setToggleGroup(toggleGroup);
            colorsHBox.getChildren().add(wheelInfo);
        }
    }
}
