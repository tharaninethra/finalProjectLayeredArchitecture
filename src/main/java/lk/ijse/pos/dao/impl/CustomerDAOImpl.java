package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CustomerDAO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList<>();

        ResultSet rst = SQLUtil.execute("SELECT * FROM customer");

        while (rst.next()) {
            Customer customer = new Customer(rst.getString("cid"), rst.getString("name")
                    ,rst.getInt("age"), rst.getInt("contact"));

            allCustomers.add(customer);
        }
        return allCustomers;
    }

    @Override
    public  boolean delete(String customerId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM customer WHERE cid=?", customerId);
    }
    @Override
    public  boolean save(Customer entity) throws SQLException, ClassNotFoundException {

        // In here you can now save your customer
        return SQLUtil.execute("INSERT INTO customer(cid,name,age,contact) VALUES(?,?,?,?)", entity.getCid(),
                entity.getName(),entity.getAge(),entity.getContact());
    }
    @Override

    public  boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE customer SET name = ?, age = ?, contact = ? WHERE cid = ?", entity.getName(),
                entity.getAge(), entity.getContact(), entity.getCid());
    }

    @Override
    public  Customer searchById(String customerId) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM customer WHERE cid=?", customerId + "");
        rst.next();
        return new Customer(customerId + "", rst.getString("name"),rst.getInt("age"),
                rst.getInt("contact"));
    }


}
