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
import lk.ijse.pos.bo.ProductBO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ProductDTO;
import lk.ijse.pos.entity.Product;
import lk.ijse.pos.view.ProductTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductFormController {
    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colItemNamee;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colStockId;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;


    @FXML
    private AnchorPane root;

    @FXML
    private TableView<ProductTm> tblProduct;

    @FXML
    private TextField txtItemId;

    @FXML
    private TextField txtItenName;

    @FXML
    private TextField txtSupId;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TextField txtQtyOnHand;

  //  private List<Product> productList = new ArrayList<>();
      ProductBO productBO= (ProductBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PRODUCT);

    // private List<Customer> customerList = new ArrayList<>();
    private  ArrayList<ProductDTO> productList = new ArrayList<>();

    public void initialize() throws IOException {
        this.productList = getAllProducts();
        setCellValueFactory();
        loadProductTable();
    }

    private void setCellValueFactory() {
        colItemId.setCellValueFactory(new PropertyValueFactory<>("pid"));
        colStockId.setCellValueFactory(new PropertyValueFactory<>("sid"));
        colItemNamee.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));

    }

    private void loadProductTable() {
        ObservableList<ProductTm> tmList = FXCollections.observableArrayList();

        for (ProductDTO product : productList) {
            ProductTm productTm = new ProductTm(
                    product.getPid(),
                    product.getSid(),
                    product.getName(),
                    product.getUnitPrice(),
                    product.getQtyOnHand()
            );

            tmList.add(productTm);
        }


        tblProduct.setItems(tmList);
        ProductTm selectedItem=  tblProduct.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem = " + selectedItem);
    }
   /* private List<Customer> getAllCustomers() {
        List<Customer> customerList = null;
        try {
            customerList = CustomerRepo.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }*/

    private ArrayList<ProductDTO> getAllProducts() {
        ArrayList<ProductDTO> productDTOS = null;
        try {
            productDTOS= ProductBO.getAllProducts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productDTOS;
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
        txtItemId.setText("");
        txtSupId.setText("");
        txtItenName.setText("");
        txtUnitPrice.setText("");
        txtQtyOnHand.setText("");

    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtItemId.getText();

        try {
            boolean isDeleted = ProductBO.deleteProducts(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "item deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtItemId.getText();
        String supid = txtSupId.getText();
        String name = txtItenName.getText();
        double unitPrice = Double.parseDouble((txtUnitPrice.getText()));
        int QtyOnHand= Integer.parseInt(txtQtyOnHand.getText());


        Product product = new Product(id, supid, name, unitPrice, QtyOnHand);

        try {
            boolean isSaved = ProductBO.saveProducts(product);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "item saved!").show();
                initialize();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtItemId.getText();
        String supid = txtSupId.getText();
        String name = txtItenName.getText();
        double unitPrice = Double.parseDouble((txtUnitPrice.getText()));
        int QtyOnHand= Integer.parseInt(txtQtyOnHand.getText());

        Product product = new Product(id, supid, name, unitPrice, QtyOnHand);

        try {
            boolean isUpdated = ProductBO.updateProducts(product);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "item updated!").show();
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





