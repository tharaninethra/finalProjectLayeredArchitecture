
package lk.ijse.pos.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.bo.BOFactory;
import lk.ijse.pos.bo.CustomerBO;
import lk.ijse.pos.bo.EmployeeBO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.EmployeeDTO;
import lk.ijse.pos.view.EmployeeTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class employeeFormController {
    @FXML
    private TableColumn<?, ?> colEmpContact;

    @FXML
    private TableColumn<?, ?> colEmpId;

    @FXML
    private TableColumn<?, ?> colEmpName;

    @FXML
    private TableColumn<?, ?> colEmpSalary;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<EmployeeTm> tblEmployee;

    @FXML
    private TextField txtEmpId;

    @FXML
    private TextField txtEmpName;

    @FXML
    private TextField txtEmpSalary;

    @FXML
    private TextField txtEmpcontact;
   // private List<Employee> employeeList = new ArrayList<>();

    EmployeeBO employeeBO= (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    // private List<Customer> customerList = new ArrayList<>();
    private  ArrayList<EmployeeDTO> employeeList = new ArrayList<>();

    public void initialize() {
        this.employeeList = getAllEmployees();
        setCellValueFactory();
        loadEmployeeTable();
    }
    private void setCellValueFactory() {
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("empid"));
        colEmpName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmpSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colEmpContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }
    private void loadEmployeeTable() {
        ObservableList<EmployeeTm> tmList = FXCollections.observableArrayList();

        for (EmployeeDTO  employee : employeeList) {
            EmployeeTm employeeTm= new EmployeeTm(
                    employee.getEmpid(),
                    employee.getName(),
                    employee.getSalary(),
                    employee.getContact()

            );

            tmList.add(employeeTm);
        }

        tblEmployee.setItems(tmList);
        EmployeeTm selectedItem = tblEmployee.getSelectionModel().getSelectedItem();

        System.out.println("selectedItem = " + selectedItem);
    }
    private ArrayList<EmployeeDTO> getAllEmployees() {
       ArrayList<EmployeeDTO> employeeDTS = null;
        try {
           employeeDTS = EmployeeBO.getAllEmployees();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeDTS;
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();

    }

    private void clearFields() {
        txtEmpId.setText("");
        txtEmpName.setText("");
        txtEmpSalary.setText("");
        txtEmpcontact.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtEmpId.getText();

        try {
            boolean isDeleted = EmployeeBO.deleteEmployees(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "employee deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        String id = txtEmpId.getText();
        String name = txtEmpName.getText();
        double salary = Double.parseDouble((txtEmpSalary.getText()));
        int contact = Integer.parseInt(txtEmpcontact.getText());

   //     Employee employee = new Employee(id, name, salary,contact);

        try {
            boolean isSaved = EmployeeBO.saveEmployees(new EmployeeDTO(id, name, salary,contact));
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "employee saved!").show();
                initialize();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtEmpId.getText();
        String name = txtEmpName.getText();
        double salary = Double.parseDouble((txtEmpSalary.getText()));
        int contact = Integer.parseInt(txtEmpcontact.getText());

    //    Employee employee = new Employee(id, name, salary,contact);

        try {
            boolean isUpdated = EmployeeBO.updateEmployees(new EmployeeDTO(id,name,salary,contact));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "employee updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/customer_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnInvoiceOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Placeorder_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnProductOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/product_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();

    }
    @FXML
    void btnShipmentOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/shipment_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnStockOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/stock_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();

    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/supplier_form.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
    }

    }






