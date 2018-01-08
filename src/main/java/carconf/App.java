package carconf;

import carconf.car_assembling.CustomizedCar;
import carconf.car_assembling.car_decorators.ColorCarDecorator;
import carconf.car_assembling.car_decorators.ModelCarDecorator;
import carconf.entity.*;
import carconf.scene.StartScene;
import carconf.service.impl.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application{
    public static CustomizedCar car;
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
        launch(args);
    }
}
