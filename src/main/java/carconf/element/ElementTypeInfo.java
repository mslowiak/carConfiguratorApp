package carconf.element;

import carconf.entity.EquipmentElement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ElementTypeInfo extends VBox{
    @FXML
    private Label descriptionLabel;

    @FXML
    private VBox elementsVBox;

    private List<CheckBox> checkBoxList;

    public ElementTypeInfo(String typeName, List<EquipmentElement> equipmentElements){
        checkBoxList = new ArrayList<>();
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/fxml/equipment_type_with_elements_info.fxml")
        );
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        descriptionLabel.setText(typeName);
        int size = equipmentElements.size();

        for(int i = 0; i < size; ++i){
            EquipmentElement elem = equipmentElements.get(i);
            HBox hBox = new HBox();
            Label price = new Label(new DecimalFormat("#").format(elem.getPrice()) + " PLN");
            CheckBox ch = new CheckBox(elem.getDescription());
            ch.setUserData(elem.getElemId());
            if(elem.getPrice() == 0){
                ch.setSelected(true);
            }

            ch.setMinWidth(1000);
            ch.setMaxWidth(1000);
            ch.setPrefWidth(1000);
            hBox.setPadding(new Insets(0,50,0,50));
            price.setPadding(new Insets(0,0,0,50));
            checkBoxList.add(ch);
            hBox.getChildren().addAll(ch, price);
            elementsVBox.getChildren().add(hBox);
        }
    }

    public List<CheckBox> getCheckBoxList() {
        return checkBoxList;
    }
}
