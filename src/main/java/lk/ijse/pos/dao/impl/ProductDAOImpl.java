package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.ProductDAO;
import lk.ijse.pos.entity.Product;
import lk.ijse.pos.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public ArrayList<Product> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Product> allProducts = new ArrayList<>();

        ResultSet rst = SQLUtil.execute("SELECT * FROM product");

        while (rst.next()) {
            Product product = new Product(rst.getString("pid"), rst.getString("sid")
                    ,rst.getString("name"), rst.getDouble("unitPrice"), rst.getInt("QtyONHand"));

            allProducts.add(product);
        }
        return allProducts;
    }
    @Override
    public  boolean delete(String productId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM product WHERE pid=?", productId);
    }
    @Override
    public  boolean save(Product entity) throws SQLException, ClassNotFoundException {

        // In here you can now save your customer
        return SQLUtil.execute("INSERT INTO product(pid, sid, name,UnitPrice, QtyOnHand) VALUES(?,?,?,?)", entity.getPid(),
                entity.getSid(),entity.getUnitPrice(),entity.getQtyOnHand());
    }
    @Override

    public  boolean update(Product entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE product SET sid = ?, name = ?, UnitPrice = ?, QtyOnHand = ?  WHERE pid = ?", entity.getSid(),
                entity.getName(), entity.getUnitPrice(), entity.getQtyOnHand());
    }

    @Override
    public  Product searchById(String productId) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM product WHERE pid= ?");
        rst.next();
        return new Product(productId + "", rst.getString("sid"),rst.getString("name"),
                rst.getDouble("UnitPrice"), rst.getInt("QtyOnHand"));
    }


}
