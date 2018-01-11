package carconf.controller;

import carconf.App;
import carconf.car_assembling.car_decorators.ModelCarDecorator;
import carconf.element.CarInfo;
import carconf.entity.Model;
import carconf.scene.ChooseEquipmentLevelScene;
import carconf.service.impl.ModelServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

import java.util.List;

public class ChooseModelSceneController {

    private Scene scene;
    private ToggleGroup radiosGroup;

    @FXML
    private Label topLabel;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button goNextButton;

    @FXML
    private Label errorLabel;


    @FXML
    void initialize() {
        radiosGroup = new ToggleGroup();
        goNextButton.setOnAction(e -> {
            if (radiosGroup.getSelectedToggle() != null) {
                int modelID = Integer.parseInt(radiosGroup.getSelectedToggle().getUserData().toString());
                ModelServiceImpl modelService = new ModelServiceImpl();
                App.car = new ModelCarDecorator(App.car, modelService.getModelById(modelID).get(0));
                App.carCaretaker.saveCustomizedCar(App.car);
                ChooseEquipmentLevelScene chooseEquipmentLevelScene = new ChooseEquipmentLevelScene(scene);
            } else {
                errorLabel.setText("Model nie został wybrany");
            }
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void displayCars() {
        ModelServiceImpl modelService = new ModelServiceImpl();
        List<Model> allModels = modelService.getAllModels();
        int column = 0;
        int row = 0;
        for (Model model : allModels) {
            CarInfo carInfo = new CarInfo(model.getBasicPrice(),
                    model.getBrand() + " " + model.getName(),
                    model.getPhotoUrl());
            carInfo.getRadioButton().setUserData(model.getModelId());
            carInfo.getRadioButton().setToggleGroup(radiosGroup);
            gridPane.add(carInfo, row, column);
            row++;
            if (row == 3) {
                row = 0;
                column++;
            }
        }
    }
}
