package lk.ijse.pos.bo.impl;

import lk.ijse.pos.bo.ProductBO;
import lk.ijse.pos.dao.CustomerDAO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.ProductDAO;
import lk.ijse.pos.dto.ProductDTO;
import lk.ijse.pos.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductBOImpl implements ProductBO {

    ProductDAO productDAO= (ProductDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PRODUCT);

    @Override
    public ArrayList<ProductDTO> getAllProducts() throws SQLException, ClassNotFoundException {
        ArrayList<ProductDTO> allProducts= new ArrayList<>();

        ArrayList<Product> all = CustomerDAO.getAll();

        for (Product p : all) {
            allProducts.add(new ProductDTO(p.getPid(),p.getSid(),p.getName(),p.getUnitPrice(), p.getQtyOnHand()));
        }
        return allProducts;
    }
    @Override
    public  boolean deleteProducts(String productId) throws SQLException, ClassNotFoundException {
        return productDAO.delete(productId);
    }

    @Override
    public  boolean saveProducts(ProductDTO dto) throws SQLException, ClassNotFoundException {
        // In here you can now save your customer

        return productDAO.save(new Product(dto.getPid(),
                dto.getSid(), dto.getName(), dto.getUnitPrice(), dto.getQtyOnHand()));

    }
    @Override

    public  boolean updateProducts(ProductDTO dto) throws SQLException, ClassNotFoundException {
        return productDAO.update(new Product(dto.getPid(),dto.getSid(),
                dto.getName(), dto.getUnitPrice(), dto.getQtyOnHand()));

    }

    @Override
    public  ProductDTO searchByIdProducts(String productId) throws SQLException, ClassNotFoundException {
      Product  p = productDAO.searchById(productId);
         return new ProductDTO(p.getPid(),p.getSid(), p.getName(),p.getUnitPrice(),p.getQtyOnHand());
    }

}
