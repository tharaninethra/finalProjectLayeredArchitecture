package lk.ijse.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProductDTO {
    private String pid;
    private String sid;
    private String name;
    private double UnitPrice;
    private int QtyOnHand;

}
