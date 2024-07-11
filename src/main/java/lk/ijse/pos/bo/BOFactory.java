package lk.ijse.pos.bo;

import lk.ijse.pos.bo.impl.CustomerBOImpl;
import lk.ijse.pos.bo.impl.ProductBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        CUSTOMER, EMPLOYEE, PRODUCT
    }

   public SuperBO getBO(BOTypes types) {
        switch (types) {
           case CUSTOMER:
                return new CustomerBOImpl();
          /*  case EMPLOYEE:
                return new EmployeeBOImpl();*/
            case PRODUCT:
               return new  ProductBOImpl();
            default:
                return null;

        }
    }
}
