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
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.view.CustomerTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerFormController {

    @FXML
    private TableColumn<?, ?> colCusAge;

    @FXML
    private TableColumn<?, ?> colCusContact;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<?, ?> colCusName;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<CustomerTm> tblCustomer;

    @FXML
    private TextField txtCusAge;

    @FXML
    private TextField txtCusContact;

    @FXML
    private TextField txtCusId;

    @FXML
    private TextField txtCusName;


    CustomerBO customerBO= (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

   // private List<Customer> customerList = new ArrayList<>();
private  ArrayList<CustomerDTO> customerList = new ArrayList<>();
    public void initialize() {
        this.customerList = getAllCustomers();
        setCellValueFactory();
        loadCustomerTable();
    }
    private void setCellValueFactory() {
        colCusId.setCellValueFactory(new PropertyValueFactory<>("cid"));
        colCusName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCusAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colCusContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }
    private void loadCustomerTable() {
        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();

      //  tblCustomer.getItems().clear();


        for (CustomerDTO customer : customerList) {
            CustomerTm customerTm = new CustomerTm(
                    customer.getCid(),
                    customer.getName(),
                    customer.getAge(),
                    customer.getContact()
            );

            tmList.add(customerTm);
        }


        tblCustomer.setItems(tmList);
        tblCustomer.refresh();
        CustomerTm selectedItem=  tblCustomer.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedItem);

    }

    private ArrayList<CustomerDTO> getAllCustomers() {
        ArrayList<CustomerDTO> customerDTOS = null;
        try {
            customerDTOS = CustomerBO.getAllCustomers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerDTOS;
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
        txtCusId.setText("");
        txtCusName.setText("");
        txtCusAge.setText("");
        txtCusContact.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event)  throws ClassNotFoundException {

        String id = txtCusId.getText();

        try {
            boolean isDeleted = CustomerBO.deleteCustomers(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtCusId.getText();
        String name = txtCusName.getText();
        int age = Integer.parseInt(txtCusAge.getText());
        int contact = Integer.parseInt(txtCusContact.getText());

      //  Customer customer = new Customer(id, name, age,contact);

        try {
            boolean isSaved = customerBO.saveCustomers(new CustomerDTO(id, name,age, contact));
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                initialize();
               // loadCustomerTable();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws ClassNotFoundException {

        String id = txtCusId.getText();
        String name = txtCusName.getText();
        int age = Integer.parseInt(txtCusAge.getText());
        int contact = Integer.parseInt(txtCusContact.getText());

      //  Customer customer = new Customer(id, name, age, contact);

        try {
            boolean isUpdated = customerBO.updateCustomers(new CustomerDTO(id, name, age, contact));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/employee_form.fxml"));
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
    @FXML
    void txtSearchOnAction(ActionEvent event) throws ClassNotFoundException {
        String id = txtCusId.getText();

        try {
         //   Customer customer = CustomerRepo.searchById(id);
            CustomerDTO customer = customerBO.searchByIdCustomers(id);

            if (customer != null) {
                txtCusId.setText(customer.getCid());
                txtCusName.setText(customer.getName());
                txtCusAge.setText(String.valueOf(customer.getAge()));
                txtCusContact.setText(String.valueOf(customer.getContact()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}







