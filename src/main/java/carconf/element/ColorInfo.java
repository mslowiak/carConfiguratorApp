package carconf.element;

import carconf.entity.Color;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ColorInfo extends VBox {
    @FXML
    private Label colorNameLabel;

    @FXML
    private ImageView colorImageView;

    @FXML
    private Label colorTypeLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private RadioButton radioButton;

    public ColorInfo(Color color) {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/fxml/color_info.fxml")
        );
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        colorNameLabel.setText(color.getDescription());
        colorTypeLabel.setText(color.getColorType());
        colorImageView.setImage(new Image(color.getPhotoUrl()));
        priceLabel.setText(color.getPrice() + " PLN");
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }

    public void setRadioButton(RadioButton radioButton) {
        this.radioButton = radioButton;
    }
}
