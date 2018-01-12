package carconf.controller;

import carconf.App;
import carconf.car_assembling.CarInformationFacade;
import carconf.car_assembling.car_object_storage.CustomizedCar;
import carconf.savers.PdfFullSaver;
import carconf.savers.PdfSimpleSaver;
import carconf.savers.SaverInterface;
import carconf.scene.ChooseEngineScene;
import carconf.scene.ChooseEquipmentElementsScene;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class ChooseDataSaverSceneController {
    private Scene scene;
    private SaverInterface saver;
    private CarInformationFacade carInformationFacade;
    @FXML
    private Label topLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label priceTextLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private javafx.scene.image.ImageView photoImageView;

    @FXML
    private HBox saversHBox;

    @FXML
    private Button pdfFullSaverButton;

    @FXML
    private Button pdfSimpleSaverButton;


    @FXML
    private Button goBackButton;



    @FXML
    void initialize(){
        carInformationFacade = new CarInformationFacade();
        descriptionLabel.setText(carInformationFacade.getFullCarDescription().toString());

        priceLabel.setText(carInformationFacade.getTotalPriceByText());

        photoImageView.setImage(carInformationFacade.getCarPhoto());

        goBackButton.setOnAction(e -> {
            App.car = new CustomizedCar(App.carCaretaker.loadCustomizedCar());
            new ChooseEquipmentElementsScene(scene);
        });

        pdfFullSaverButton.setOnAction(e ->{
            saver = new PdfFullSaver();
            saver.saveCarConfiguration();
        });

        pdfSimpleSaverButton.setOnAction(e -> {
            saver = new PdfSimpleSaver();
            saver.saveCarConfiguration();
        } );

    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

//    public void displayOptionForSavingConfiguration(){
//    }
}
