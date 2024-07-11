package lk.ijse.pos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    public  boolean delete(String id) throws SQLException, ClassNotFoundException;
    public  boolean save(T entity) throws SQLException, ClassNotFoundException ;
    public  boolean update(T entity) throws SQLException, ClassNotFoundException;
    public  T searchById(String id) throws SQLException, ClassNotFoundException;


    /*public ArrayList<String> currentId() throws SQLException, ClassNotFoundException;

    ArrayList<String> getIds() throws SQLException, ClassNotFoundException;

    boolean updateQty(ArrayList<T> mdList) throws SQLException, ClassNotFoundException;

    boolean save(ArrayList<T> mdList) throws SQLException, ClassNotFoundException;

    int getCount() throws SQLException, ClassNotFoundException;*/


}
