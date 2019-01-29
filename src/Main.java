import javafx.application.Application;
import javafx.stage.Stage;
import controller.Utils;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new Utils().sceneInitializer(primaryStage, "/view/pages/Start/Start.fxml");

    }

    public static void main(String[] args) {
        launch(args);
    }

}
