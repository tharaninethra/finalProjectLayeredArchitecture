package lk.ijse.pos.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data


public class CustomerDTO {
    private  String cid;
    private String name;
    private  int age;
    private int contact;

}
