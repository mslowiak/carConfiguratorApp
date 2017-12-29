package carconf.element;

import carconf.entity.Engine;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class EngineInfo extends HBox {

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label horsePowerLabel;

    @FXML
    private Label fuelTypeLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private RadioButton radioButton;

    public EngineInfo(String id, Engine engine) {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/fxml/engine_info.fxml")
        );
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        idLabel.setText(id);
        nameLabel.setText(engine.getName());
        horsePowerLabel.setText(engine.getPowerKM() + " KM");
        fuelTypeLabel.setText(engine.getFuel());
        priceLabel.setText(engine.getPrice() + " PLN");
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }

    public void setRadioButton(RadioButton radioButton) {
        this.radioButton = radioButton;
    }
}
