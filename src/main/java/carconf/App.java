package carconf;

import carconf.car_assembling.CustomizedCar;
import carconf.car_assembling.car_decorators.ColorCarDecorator;
import carconf.car_assembling.car_decorators.ModelCarDecorator;
import carconf.entity.Color;
import carconf.entity.Model;
import carconf.scene.StartScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{
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

    public static int modelId;
    public static int levelId;

    public static void main(String[] args) {
//        CustomizedCar cc = new CustomizedCar();
//        Model model = new Model("Sandero", "Dacia", 1733, 1519, 4069);
//        Color color = new Color(model, "Biel Alpejska", "niemetalizowany", 0, "www.onet.pl");
//
//        cc = new ColorCarDecorator(cc, color);
//        System.out.println(cc.getCarContent().getColor().getDescription());
//        cc = new ModelCarDecorator(cc, model);
//        System.out.println(cc.getCarContent().getColor().getDescription());
//        System.out.println(cc.getCarContent().getModel().getBrand());
        launch(args);
    }
}
