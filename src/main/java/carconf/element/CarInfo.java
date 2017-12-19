package carconf.element;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.text.DecimalFormat;

public class CarInfo extends AnchorPane{

    @FXML
    private ImageView carImageView;

    @FXML
    private Label carDesriptionLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private RadioButton radioButton;

    public CarInfo(float price, String carDescription, String imageUrl) {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/fxml/car_info.fxml")
        );
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        priceLabel.setText("już od: " + new DecimalFormat("#").format(price) + " PLN");
        carDesriptionLabel.setText(carDescription);
        carImageView.setImage(new Image(imageUrl));
    }

    @FXML
    private void initialize() {
    }

    public ImageView getCarImageView() {
        return carImageView;
    }

    public Label getCarDesriptionLabel() {
        return carDesriptionLabel;
    }

    public Label getPriceLabel() {
        return priceLabel;
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }
}
