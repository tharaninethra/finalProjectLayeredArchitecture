package lk.ijse.pos.bo.impl;

import lk.ijse.pos.bo.CustomerBO;
import lk.ijse.pos.dao.CustomerDAO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers= new ArrayList<>();

        ArrayList<Customer> all = CustomerDAO.getAll();

        for (Customer c : all) {
            allCustomers.add(new CustomerDTO(c.getCid(),c.getName(),c.getAge(),c.getContact()));
        }
        return allCustomers;
    }
    @Override
    public  boolean deleteCustomers(String customerId) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(customerId);
    }

    @Override
    public  boolean saveCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        // In here you can now save your customer

        return customerDAO.save(new Customer(dto.getCid(),
                dto.getName(), dto.getAge(), dto.getContact()));

    }
    @Override

    public  boolean updateCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getCid(),
                dto.getName(), dto.getAge(), dto.getContact()));

    }

    @Override
    public  CustomerDTO searchByIdCustomers(String customerId) throws SQLException, ClassNotFoundException {
        Customer c = customerDAO.searchById(customerId);
        return new CustomerDTO(c.getCid(),c.getName(),c.getAge(),c.getContact());
    }


}
