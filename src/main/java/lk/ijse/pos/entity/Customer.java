package lk.ijse.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

public class Customer {

    private  String cid;
    private String name;
    private  int age;
    private int contact;
}
