package carconf.element;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataSaverInfo extends VBox {
    @FXML
    private Label descriptionLabel;

    @FXML
    private VBox elementsVBox;

    private List<CheckBox> checkBoxList;

    public DataSaverInfo(String saverName){
//        checkBoxList = new ArrayList<>();
//        FXMLLoader fxmlLoader = new FXMLLoader(
//                getClass().getResource("/fxml/dataSaver_info.fxml")
//        );
//        fxmlLoader.setRoot(this);
//        fxmlLoader.setController(this);
//
//        try {
//            fxmlLoader.load();
//        } catch (IOException exception) {
//            throw new RuntimeException(exception);
//        }
//
//        descriptionLabel.setText(saverName);
//            HBox hBox = new HBox();
//
//            CheckBox ch = new CheckBox();
//            ch.setUserData(1);
//
//            ch.setMinWidth(1000);
//            ch.setMaxWidth(1000);
//            ch.setPrefWidth(1000);
//            hBox.setPadding(new Insets(0,50,0,50));
//
//            checkBoxList.add(ch);
//            hBox.getChildren().add(ch);
//            elementsVBox.getChildren().add(hBox);
        }
}
