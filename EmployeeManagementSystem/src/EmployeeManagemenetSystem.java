import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeeManagemenetSystem extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("RegistrationLogin.fxml"));

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();

        // throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
