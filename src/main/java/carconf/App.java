package carconf;

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
        launch(args);
    }
}
