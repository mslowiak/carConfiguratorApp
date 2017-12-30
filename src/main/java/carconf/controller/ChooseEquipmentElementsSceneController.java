package carconf.controller;

import carconf.App;
import carconf.element.ElementTypeInfo;
import carconf.entity.EquipmentElement;
import carconf.entity.EquipmentType;
import carconf.service.impl.EquipmentElementServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ChooseEquipmentElementsSceneController {
    private Scene scene;

    @FXML
    private Label topLabel;

    @FXML
    private VBox equipmentElemsVBox;

    @FXML
    private Button goBackButton;

    @FXML
    private Button goNextButton;

    @FXML
    void initialize(){
        goBackButton.setOnAction(e -> {

        });

        goNextButton.setOnAction(e -> {

        });
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void displayElements() {
        EquipmentElementServiceImpl equipmentElementService = new EquipmentElementServiceImpl();
        List<EquipmentElement> equipmentElements = equipmentElementService.getEquipmentElementsByLevelId(App.levelId);
        Set<Integer> set = new HashSet<>();
        for (EquipmentElement e : equipmentElements){
            set.add(e.getEquipmentType().getType_ID());
        }
        List<Integer> uniqueTypeId = new ArrayList<>(set);

        for (int i = 0; i < uniqueTypeId.size(); ++i){
            int finalI = i;
            List<EquipmentElement> collectedElements = equipmentElements.stream()
                    .filter(e -> e.getEquipmentType().getType_ID() == uniqueTypeId.get(finalI))
                    .collect(Collectors.toList());
            ElementTypeInfo elementTypeInfo = new ElementTypeInfo(collectedElements.get(0).getEquipmentType().getDescription(), collectedElements);
            equipmentElemsVBox.getChildren().add(elementTypeInfo);
        }
    }
}
