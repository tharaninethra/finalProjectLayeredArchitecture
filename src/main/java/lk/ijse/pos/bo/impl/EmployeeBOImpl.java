package lk.ijse.pos.bo.impl;

import lk.ijse.pos.bo.EmployeeBO;
import lk.ijse.pos.dao.CustomerDAO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.EmployeeDAO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.EmployeeDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO= (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public ArrayList<EmployeeDTO> getAlEmployees() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeDTO> allEmployees= new ArrayList<>();

        ArrayList<Employee> all = EmployeeDAO.getAll();

        for (Employee e : all) {
           allEmployees.add(new EmployeeDTO(e.getEmpid(),e.getName(),e.getSalary(),e.getContact()));
        }
        return allEmployees;
    }
    @Override
    public  boolean deleteEmployees(String employeeId) throws SQLException, ClassNotFoundException {
        return EmployeeDAO.delete(employeeId);
    }

    @Override
    public  boolean saveEmployees(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        // In here you can now save your customer

        return employeeDAO.save(new Employee(dto.getEmpid(),
                dto.getName(), dto.getSalary(), dto.getContact()));

    }
    @Override

    public  boolean updateEmployees(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(dto.getEmpid(),
                dto.getName(), dto.getSalary(), dto.getContact()));

    }

    @Override
    public  EmployeeDTO searchByIdEmployees(String employeeId) throws SQLException, ClassNotFoundException {
       Employee c = employeeDAO.searchById(employeeId);
        return new EmployeeDTO(c.getEmpid(),c.getName(),c.getSalary(),c.getContact());
    }
}
