package lk.ijse.pos.bo;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBO extends SuperBO{
    public ArrayList<EmployeeDTO> getAlEmployees() throws SQLException, ClassNotFoundException;
    public  boolean deleteEmployees(String employeeId) throws SQLException, ClassNotFoundException;
    public  boolean saveEmployees(EmployeeDTO dto) throws SQLException, ClassNotFoundException ;
    public  boolean updateEmployees(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
    public EmployeeDTO searchByIdEmployees(String employeeId) throws SQLException, ClassNotFoundException;


}
