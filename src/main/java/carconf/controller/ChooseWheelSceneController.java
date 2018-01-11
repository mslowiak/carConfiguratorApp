package carconf.controller;

import carconf.App;
import carconf.car_assembling.car_decorators.WheelCarDecorator;
import carconf.car_assembling.car_object_storage.CustomizedCar;
import carconf.element.WheelInfo;
import carconf.entity.Wheel;
import carconf.scene.ChooseColorScene;
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
    private ToggleGroup radiosGroup;

    @FXML
    private Label topLabel;

    @FXML
    private HBox colorsHBox;

    @FXML
    private Button goBackButton;

    @FXML
    private Button goNextButton;

    @FXML
    private Label errorLabel;

    @FXML
    void initialize() {
        radiosGroup = new ToggleGroup();

        goBackButton.setOnAction(e -> {
            App.car = new CustomizedCar(App.carCaretaker.loadCustomizedCar());
            new ChooseColorScene(scene);
        });

        goNextButton.setOnAction(e -> {
            if (radiosGroup.getSelectedToggle() != null) {
                int wheelId = Integer.parseInt(radiosGroup.getSelectedToggle().getUserData().toString());
                WheelServiceImpl wheelService = new WheelServiceImpl();
                App.car = new WheelCarDecorator(App.car, wheelService.getWheelByWheelId(wheelId).get(0));
                App.carCaretaker.saveCustomizedCar(App.car);
                ChooseEquipmentElementsScene chooseEquipmentElementsScene = new ChooseEquipmentElementsScene(scene);
            } else {
                errorLabel.setText("Felgi nie zostały wybrane");
            }
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void displayWheels() {
        WheelServiceImpl wheelService = new WheelServiceImpl();
        List<Wheel> wheelsByLevelId = wheelService.getWheelsByLevelId(App.car.getCarContent().getEquipmentLevel().getLevelId());
        for (int i = 0; i < wheelsByLevelId.size(); ++i) {
            Wheel wheel = wheelsByLevelId.get(i);
            WheelInfo wheelInfo = new WheelInfo(wheel);
            wheelInfo.getRadioButton().setUserData(i);
            wheelInfo.getRadioButton().setToggleGroup(radiosGroup);
            colorsHBox.getChildren().add(wheelInfo);
        }
    }
}
