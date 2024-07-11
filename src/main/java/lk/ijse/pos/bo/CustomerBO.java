package lk.ijse.pos.bo;

import lk.ijse.pos.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO{
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
    public  boolean deleteCustomers(String customerId) throws SQLException, ClassNotFoundException;
    public  boolean saveCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException ;
    public  boolean updateCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    public CustomerDTO searchByIdCustomers(String customerId) throws SQLException, ClassNotFoundException;




  //  int getCustomerCount() throws SQLException, ClassNotFoundException;*/
}
