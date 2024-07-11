package lk.ijse.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

public class Stock {
    private  String sid;
    private int qty;
    private String level;
}
