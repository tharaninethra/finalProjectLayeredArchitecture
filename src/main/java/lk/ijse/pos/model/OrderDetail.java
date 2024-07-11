package lk.ijse.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDetail {
  //  private  String odId;
    private  String  oid;
    private  String pid;
    private  int qty;

}
