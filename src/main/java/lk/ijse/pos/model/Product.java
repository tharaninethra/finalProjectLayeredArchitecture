package lk.ijse.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

public class Product {
    private String pid;
    private String sid;
    private String name;
    private double UnitPrice;
    private int QtyOnHand;

}
