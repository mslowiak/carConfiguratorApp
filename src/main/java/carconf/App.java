package carconf;

import carconf.car_assembling.CustomizedCarCaretaker;
import carconf.car_assembling.car_object_storage.CustomizedCar;
import carconf.scene.StartScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{
    public static CustomizedCar car;
    public static CustomizedCarCaretaker carCaretaker;
    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("carConfiguratorApp");
        Scene scene = new Scene(new VBox(), 1600, 1000);
        window.setScene(scene);
        new StartScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        car = new CustomizedCar();
        carCaretaker = new CustomizedCarCaretaker();
        launch(args);
    }
}
