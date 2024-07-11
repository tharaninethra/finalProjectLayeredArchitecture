package lk.ijse.pos.dao;

import lk.ijse.pos.dao.impl.CustomerDAOImpl;
import lk.ijse.pos.dao.impl.EmployeeDAOImpl;
import lk.ijse.pos.dao.impl.ProductDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER, PRODUCT, ORDER, ORDER_DETAILS, EMPLOYEE
    }

   public SuperDAO getDAO(DAOTypes types) {
       switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
           case PRODUCT:
                return new ProductDAOImpl();
          /*  case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAILS:
                return new OrderDetailsDAOImpl();*/
           case EMPLOYEE:
               return  new EmployeeDAOImpl();
            default:
                return null;
        }
    }
}
