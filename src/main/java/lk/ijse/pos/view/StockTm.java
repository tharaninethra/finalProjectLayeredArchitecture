package lk.ijse.pos.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class StockTm {
    private  String sid;
    private int qty;
    private String level;
}
