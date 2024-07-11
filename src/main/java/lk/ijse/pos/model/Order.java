package lk.ijse.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Order {
public String oid;
private  String cid;
private  Date date;
private  String empid;
}
