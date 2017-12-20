package carconf.controller;

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

public class ChooseCarSceneController {

    private Scene scene;

    @FXML
    private Label topLabel;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button goNextButton;

    @FXML
    void initialize(){
        goNextButton.setOnAction(e ->{
            new ChooseEquipmentLevelScene(scene);
        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void displayCars(){
        ModelServiceImpl modelService = new ModelServiceImpl();
        List<Model> allModels = modelService.getAllModels();
        int column = 0;
        int row = 0;
        ToggleGroup toggleGroup = new ToggleGroup();
        for (int i=0; i<allModels.size(); ++i){
            Model model = allModels.get(i);
            if(model.getPhotoUrl() != null){
                CarInfo carInfo = new CarInfo(model.getBasicPrice(),
                        model.getBrand() + " " + model.getName(),
                        model.getPhotoUrl());
                carInfo.getRadioButton().setToggleGroup(toggleGroup);
                gridPane.add(carInfo, row, column);
                row++;
                if(row == 3){
                    row = 0;
                    column++;
                }
            }
        }
    }
}
