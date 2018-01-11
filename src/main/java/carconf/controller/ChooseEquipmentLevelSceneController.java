package carconf.controller;

import carconf.App;
import carconf.car_assembling.car_decorators.EquipmentLevelCarDecorator;
import carconf.car_assembling.car_object_storage.CustomizedCar;
import carconf.element.EquipmentLevelInfo;
import carconf.entity.EquipmentLevel;
import carconf.scene.ChooseEngineScene;
import carconf.scene.ChooseModelScene;
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
    void initialize() {
        radiosGroup = new ToggleGroup();
        goBackButton.setOnAction(e -> {
            App.car = new CustomizedCar(App.carCaretaker.loadCustomizedCar());
            new ChooseModelScene(scene);
        });
        goNextButton.setOnAction(e -> {
            if (radiosGroup.getSelectedToggle() != null) {
                int equipmentLevelID = Integer.parseInt(radiosGroup.getSelectedToggle().getUserData().toString());
                EquipmentLevelServiceImpl levelService = new EquipmentLevelServiceImpl();
                int modelID = App.car.getCarContent().getModel().getModelId();
                App.car = new EquipmentLevelCarDecorator(App.car,
                        levelService.getEquipmentLevelByEquipmentLevelIdAndModelId(equipmentLevelID, modelID).get(0));
                App.carCaretaker.saveCustomizedCar(App.car);
                ChooseEngineScene chooseEngineScene = new ChooseEngineScene(scene);
            } else {
                errorLabel.setText("Rodzaj wyposażenia nie został wybrany");
            }
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void displayEquipmentLevelScene() {
        EquipmentLevelServiceImpl equipmentLevelService = new EquipmentLevelServiceImpl();
        List<EquipmentLevel> equipmentLevelsByModelId = equipmentLevelService.getEquipmentLevelsByModelId(App.car.getCarContent().getModel().getModelId());
        for (int i = 0; i < equipmentLevelsByModelId.size(); ++i) {
            EquipmentLevel e = equipmentLevelsByModelId.get(i);
            EquipmentLevelInfo equipmentLevelInfo = new EquipmentLevelInfo((i + 1) + ".", e.getName(), new DecimalFormat("#").format(e.getPrice()) + " PLN");
            equipmentLevelInfo.getRadioButton().setUserData(e.getLevelId());
            equipmentLevelInfo.getRadioButton().setToggleGroup(radiosGroup);
            equipmentLevelsVBox.getChildren().add(equipmentLevelInfo);
        }
    }
}
