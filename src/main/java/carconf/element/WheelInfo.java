package carconf.element;

import carconf.entity.Wheel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.text.DecimalFormat;

public class WheelInfo extends VBox {
    @FXML
    private Label descriptionLabel;

    @FXML
    private Label wheelSizeLabel;

    @FXML
    private ImageView wheelImageView;

    @FXML
    private Label priceLabel;

    @FXML
    private RadioButton radioButton;

    public WheelInfo(Wheel wheel) {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/fxml/wheel_info.fxml")
        );
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        descriptionLabel.setText(wheel.getDescription());
        wheelSizeLabel.setText(wheel.getSize() + "'");
        wheelImageView.setImage(new Image(wheel.getPhotoUrl()));
        priceLabel.setText(new DecimalFormat("#").format(wheel.getPrice()) + " PLN");
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }

    public void setRadioButton(RadioButton radioButton) {
        this.radioButton = radioButton;
    }
}
