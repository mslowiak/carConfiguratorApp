package carconf.controller;

import carconf.App;
import carconf.element.ColorInfo;
import carconf.entity.Color;
import carconf.scene.ChooseWheelScene;
import carconf.service.impl.ColorServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

import java.util.List;

public class ChooseColorSceneController {

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
            ChooseWheelScene chooseWheelScene = new ChooseWheelScene(scene);
            chooseWheelScene.getChooseWheelSceneController().displayWheels();
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void displayColors(){
        ColorServiceImpl colorService = new ColorServiceImpl();
        List<Color> colorsByModelId = colorService.getColorsByModelId(App.modelId);
        for(int i = 0; i < colorsByModelId.size(); ++i){
            Color color = colorsByModelId.get(i);
            ColorInfo colorInfo = new ColorInfo(color);
            colorInfo.getRadioButton().setUserData(i);
            colorInfo.getRadioButton().setToggleGroup(toggleGroup);
            colorsHBox.getChildren().add(colorInfo);
        }
    }
}
