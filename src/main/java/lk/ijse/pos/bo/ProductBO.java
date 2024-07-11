package lk.ijse.pos.bo;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ProductDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductBO extends SuperBO{

    public ArrayList<ProductDTO> getAllProducts() throws SQLException, ClassNotFoundException;
    public  boolean deleteProducts(String productId) throws SQLException, ClassNotFoundException;
    public  boolean saveProducts(ProductDTO dto) throws SQLException, ClassNotFoundException ;
    public  boolean updateProducts(ProductDTO dto) throws SQLException, ClassNotFoundException;
 //   public ProductDTO searchByIdProductss(String productId) throws SQLException, ClassNotFoundException;


    ProductDTO searchByIdProducts(String productId) throws SQLException, ClassNotFoundException;
}
