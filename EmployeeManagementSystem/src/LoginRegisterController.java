
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import Models.User;
import Models.UserFileManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginRegisterController {
    ArrayList<User> users = new ArrayList<>();

    @FXML
    private Label lblwarning;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    /**
     * @param event
     * @throws FileNotFoundException
     * @throws IOException
     */
    @FXML
    void btnLogin(ActionEvent event) throws FileNotFoundException, IOException {
        users = UserFileManager.getUsers();
        boolean isUser = false;
        lblwarning.setText("");
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUserName().equals(txtUserName.getText()) && user.getPassword().equals(txtPassword.getText())) {
                // qualified user
                System.out.println("Confirmed");
                isUser = true;

                // ?? Previous stage should be close it is not ended.
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("EmployeeManagement.fxml"));

                Scene scene = new Scene(root, 658, 493);

                stage.setTitle("FXML");
                stage.setScene(scene);
                stage.show();
            }
        }
        if (!isUser) {
            lblwarning.setText("User name and password are incorrect");
        }
    }

    @FXML
    void btnRegister(ActionEvent event) throws IOException {
        User user = new User();
        user.setUserName(txtUserName.getText());
        user.setPassword(txtPassword.getText());
        users.add(user);
        UserFileManager.saveUsers(users);
    }

    @FXML
    void btnResetPassword(ActionEvent event) {
        // Will Implement later
    }

}
