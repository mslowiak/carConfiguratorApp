package carconf.controller;

import carconf.App;
import carconf.car_assembling.car_decorators.ColorCarDecorator;
import carconf.car_assembling.car_object_storage.CustomizedCar;
import carconf.element.ColorInfo;
import carconf.entity.Color;
import carconf.scene.ChooseEngineScene;
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
            new ChooseEngineScene(scene);
        });

        goNextButton.setOnAction(e -> {
            if (radiosGroup.getSelectedToggle() != null) {
                int colorId = Integer.parseInt(radiosGroup.getSelectedToggle().getUserData().toString());
                ColorServiceImpl colorService = new ColorServiceImpl();
                App.car = new ColorCarDecorator(App.car, colorService.getColorByColorId(colorId).get(0));
                App.carCaretaker.saveCustomizedCar(App.car);
                ChooseWheelScene chooseWheelScene = new ChooseWheelScene(scene);
            } else {
                errorLabel.setText("Kolor nie został wybrany");
            }
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void displayColors() {
        ColorServiceImpl colorService = new ColorServiceImpl();
        List<Color> colorsByModelId = colorService.getColorsByModelId(App.car.getCarContent().getModel().getModelId());
        for (int i = 0; i < colorsByModelId.size(); ++i) {
            Color color = colorsByModelId.get(i);
            ColorInfo colorInfo = new ColorInfo(color);
            colorInfo.getRadioButton().setUserData(i);
            colorInfo.getRadioButton().setToggleGroup(radiosGroup);
            colorsHBox.getChildren().add(colorInfo);
        }
    }
}
