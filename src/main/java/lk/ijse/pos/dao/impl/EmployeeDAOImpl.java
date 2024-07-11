package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.EmployeeDAO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Employee;
import lk.ijse.pos.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public ArrayList<Employee> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Employee> allEmployees = new ArrayList<>();

        ResultSet rst = SQLUtil.execute("SELECT * FROM employee");

        while (rst.next()) {
           Employee employee = new Employee(rst.getString("empid"), rst.getString("name")
                    ,rst.getDouble("salary"), rst.getInt("contact"));

            allEmployees.add(employee);
        }
        return allEmployees;
    }

    @Override
    public  boolean delete(String employeeId) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE empid=?", employeeId);
    }



    @Override
    public  boolean save(Employee entity) throws SQLException, ClassNotFoundException {


        return SQLUtil.execute("INSERT INTO employee(empid,name,salary,contact) VALUES(?,?,?,?)", entity.getEmpid(),
                entity.getName(),entity.getSalary(),entity.getContact());
    }
    @Override

    public  boolean update(Employee entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE  employee SET name = ?, salary = ?, contact = ? WHERE empid = ?", entity.getName(),
                entity.getSalary(), entity.getContact());
    }

    @Override
    public  Employee searchById(String employeeId) throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM employee WHERE empid=?", employeeId + "");
        rst.next();
        return new Employee(employeeId + "", rst.getString("name"),rst.getDouble("salary"),
                rst.getInt("contact"));
    }

}
