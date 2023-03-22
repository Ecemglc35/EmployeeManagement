import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Models.Employee;
import Models.EmployeeFileManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeManagementController implements Initializable {
    ArrayList<Employee> employees = new ArrayList<>();

    @FXML
    private RadioButton fullTime;

    @FXML
    private RadioButton partTime;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> tblDepartment;

    @FXML
    private String tblId;

    @FXML
    private TableColumn<?, ?> tblName;

    @FXML
    private TableColumn<?, ?> tblSalary;

    @FXML
    private TextField txtDepartment;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtHourlyRate;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtTotalHours;

    @FXML
    void btnAdd(ActionEvent event) {

    }

    @FXML
    void btnDelete(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            employees = EmployeeFileManager.getEmployees();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        // Set up table data
        ObservableList<Employee> employeeData = FXCollections.observableArrayList(employees);
        table.setItems(employeeData);
        // throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

}
